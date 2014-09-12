package com.fun.playinfo.client;

import junit.framework.TestCase;

import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * 基础测试用例类，统一设置socket等公用信息 <br/>
 * Date: 2014-9-5 上午11:39:56 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class BaseTestCase extends TestCase {
	protected static String host = "localhost";
	protected static int port = 9095;
	protected static TTransport socket = null;
	static {
		socket = new TSocket(host, port, 50000);
	}
}
