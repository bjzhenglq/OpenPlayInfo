package com.fun.playinfo.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TTransportException;

import com.fun.playinfo.constant.IRPCServiceName;
import com.fun.playinfo.thrift.OpenPlayInfoService;
import com.fun.playinfo.thrift.PlayInfoVOResult;

/**
 * 
 * 查询接口的测试用例<br/>
 * date: 2014-9-5 上午11:41:44 <br/>
 * 
 * @version
 * @author zhenglq
 * @since JDK 1.7
 */
public class OpenPlayQryTestCase extends BaseTestCase {
	private final static int vedioID = 2;
	private final String hashID = "84ee07ff14e2d6b02d517b0c2d8152172baadbe0";
	private static List<Integer> playIDs;
	private static List<Integer> vedioList = null;
	private static List<String> hashIDs = null;

	static {
		vedioList = new ArrayList<Integer>();
		vedioList.add(459996);
		vedioList.add(458914);
		hashIDs = new ArrayList<String>();
		hashIDs.add("84ee07ff14e2d6b02d517b0c2d8152172baadbe0");
		hashIDs.add("1B7D9765976475C642788A79A9A6E91072F38197");
		playIDs = new ArrayList<Integer>();
		playIDs.add(1508076);
		playIDs.add(1508045);
	}

	public void testGetInfoByVideoID() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				//
				PlayInfoVOResult playInfo = client.getInfoByVideoID(vedioID);
				System.out.println("testGetInfoByVideoID:" + playInfo);
			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public void testGetInfoByVideoIDList() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				//
				PlayInfoVOResult playInfo = client
						.getInfoByVideoIDList(vedioList);
				System.out.println("testGetInfoByVideoIDList:" + playInfo);
			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public void testGetInfoByPlayIDList() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				PlayInfoVOResult playInfo = client.getInfoByPlayIDList(playIDs);
				System.out.println("testGetInfoByPlayIDList:" + playInfo);
			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public void testGetInfoByVideoANDHashIDList() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				PlayInfoVOResult playInfo = client.getInfoByVideoANDHashIDList(
						vedioList, hashIDs);
				System.out.println("testGetInfoByVideoANDHashIDList:"
						+ playInfo);

			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public void testGetInfoByHashIDList() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				PlayInfoVOResult playInfo = client.getInfoByHashIDList(hashIDs);
				System.out.println("testGetInfoByHashIDList:" + playInfo);

			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public void testGetInfoByHashID() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_SERVICE);
			OpenPlayInfoService.Client client = new OpenPlayInfoService.Client(
					mp1);
			try {
				PlayInfoVOResult playInfo = client.getInfoByHashID(hashID);
				System.out.println("testGetInfoByHashID:" + playInfo);
			} catch (TException e) {

			} finally {
				socket.close();
			}
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
