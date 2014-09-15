package com.fun.playinfo.server;

import java.io.IOException;
import java.util.concurrent.Executors;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

import com.fun.playinfo.constant.IRPCServiceName;
import com.fun.playinfo.service.OpenPlayInfoOPServiceImpl;
import com.fun.playinfo.service.OpenPlayInfoServiceImpl;
import com.fun.playinfo.service.PlayInfoHandler;
import com.fun.playinfo.thread.FullUpdateThread;
import com.fun.playinfo.thread.UpdateThread;
import com.fun.playinfo.thrift.OpenPlayInfoOpService;
import com.fun.playinfo.thrift.OpenPlayInfoService;
import com.fun.playinfo.utils.CCHandler;
import com.fun.playinfo.utils.LogHelper;
import com.funshion.configcenter.ConfigCenter;

public class ThriftServer {
	private final String confFile = "conf-dev.conf";
	private final int rpcPort;
	private final int httpPort;
	private final int readTimeout;
	private final int workerNum;
	private final PlayInfoConf conf;
	// thrift接口允许的参数列表最大长度
	private final int idListMaxLen;
	private TServer server;
	private TServerSocket socket;

	private boolean atService = false;
	private final int updateInterval;
	private final int fullUpdateInterval;
	private final PlayInfoHandler handler;
	private final LogHelper log = new LogHelper("ThriftServer");

	public ThriftServer() throws Exception {
		conf = new PlayInfoConf(confFile);
		this.rpcPort = conf.rpcPort;
		this.httpPort = conf.httpPort;
		this.readTimeout = conf.readTimeout;
		this.workerNum = conf.workerNum;
		this.idListMaxLen = conf.idListMaxLen;
		updateInterval = conf.updateInterval;
		fullUpdateInterval = conf.fullUpdateInterval;
		initCounters();
		handler = PlayInfoHandler.getInstance();
	}

	/**
	 * 
	 * 初始化程序计数器<br/>
	 * 
	 * @throws IOException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void initCounters() throws IOException {
		// 供程序计数器使用
		String[] handlerNams = { "getInfoByVideoID", "getInfoByVideoIDList",
				"getInfoByHashID", "getInfoByPlayIDList",
				"getInfoByHashIDList", "getInfoByVideoANDHashIDList",
				"addPlayInfos", "updatePlayInfos", "addFileTypes",
				"updateFileTypes", "addDefinitions", "updateDefinitions" };

		LogHelper logHelper = new LogHelper("CCClient");
		CCHandler handler = new CCHandler(handlerNams);
		ConfigCenter.start(conf.ccHost, conf.localName, conf.httpPort,
				logHelper.logger);
		ConfigCenter.regConfigNotify(handler);
	}

	public void startService() throws TTransportException, IOException {
		// 内存数据初始化
		handler.initMemory();
		// 定时更新数据
		UpdateThread updateThread = new UpdateThread(handler, updateInterval);
		updateThread.start();
		// 全数据更新
		FullUpdateThread fullThread = new FullUpdateThread(handler,
				fullUpdateInterval);
		fullThread.start();

		socket = new TServerSocket(rpcPort, readTimeout);
		TThreadPoolServer.Args args = new TThreadPoolServer.Args(socket);
		// 以帧为传输单位，帧结构为：4个字节（int32_t）+传输字节串，头4个字节是存储后面字节串的长度，
		// 该字节串才是正确需要传输的数据，有缓存
		TTransportFactory transPort = new TFramedTransport.Factory();
		args.transportFactory(transPort);
		// 采用二进制协议
		TProtocolFactory protocalFactory = new TBinaryProtocol.Factory();
		args.protocolFactory(protocalFactory);

		// 支持多RPC服务
		TMultiplexedProcessor processor = new TMultiplexedProcessor();
		// 注册播放信息查询服务
		processor.registerProcessor(IRPCServiceName.OPEN_PLAY_INFO_SERVICE,
				new OpenPlayInfoService.Processor<OpenPlayInfoService.Iface>(
						new OpenPlayInfoServiceImpl()));
		// 注册播放信息增删改服务
		processor
				.registerProcessor(
						IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE,
						new OpenPlayInfoOpService.Processor<OpenPlayInfoOpService.Iface>(
								new OpenPlayInfoOPServiceImpl()));
		args.processor(processor);
		// 固定线程数，可通过配置文件配置
		args.executorService(Executors.newFixedThreadPool(workerNum));

		server = new TThreadPoolServer(args);
		log.warn(
				"start threadedpool server, rpc_port: %d, http_port: %d, workers: %d",
				rpcPort, httpPort, workerNum);
		atService = true;
		server.serve();
		atService = false;

		log.error("the open playinfo server has been started");
	}

	public void close() {
		TServer server = this.server;
		if (server != null) {
			server.stop();
			this.server = null;
		}
		TServerSocket socket = this.socket;
		if (socket != null) {
			socket.close();
			this.socket = null;
		}
		atService = false;
	}

	public int getIdListMaxLen() {
		return idListMaxLen;
	}

	@Override
	public void finalize() {
		close();
	}

	public boolean isAtService() {
		return atService;
	}
}
