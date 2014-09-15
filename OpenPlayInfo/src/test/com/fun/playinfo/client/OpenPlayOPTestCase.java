package com.fun.playinfo.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;

import com.fun.playinfo.constant.IRPCServiceName;
import com.fun.playinfo.thrift.DefinitionOPResult;
import com.fun.playinfo.thrift.DefinitionVO;
import com.fun.playinfo.thrift.FileTypeOPResult;
import com.fun.playinfo.thrift.FileTypeVO;
import com.fun.playinfo.thrift.OpenPlayInfoOpService;
import com.fun.playinfo.thrift.OpenPlayInfoVO;
import com.fun.playinfo.thrift.PlayInfoOPResult;

/**
 * 
 * 查询接口的测试用例<br/>
 * date: 2014-9-5 上午11:41:44 <br/>
 * 
 * @version
 * @author zhenglq
 * @since JDK 1.7
 */
public class OpenPlayOPTestCase extends BaseTestCase {
	private final static int vedioID = 2;
	private static List<Integer> playIDs;
	private static List<Integer> vedioList = null;
	private static List<String> hashIDs = null;

	static {
		vedioList = new ArrayList<Integer>();
		vedioList.add(1);
		vedioList.add(2);
		hashIDs = new ArrayList<String>();
		hashIDs.add("84ee07ff14e2d6b02d517b0c2d8152172baadec9");
		hashIDs.add("84ee07ff14e2d6b02d517b0c2d8152172baadec0");
		playIDs = new ArrayList<Integer>();
		playIDs.add(1);
		playIDs.add(2);
	}

	public void testAddPlayInfos() {
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch);
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);

			List<OpenPlayInfoVO> playInfoVOs = new ArrayList<OpenPlayInfoVO>();
			OpenPlayInfoVO playInfoVO = new OpenPlayInfoVO();
			playInfoVO.setVideoID(2);
			playInfoVO.setHashID("84ee07ff14e2d6b02d517b0c2d8152172baadae0");
			playInfoVO.setDefinitionID(1);
			playInfoVO.setFileSize(200000);
			playInfoVO.setVedioTypeID(10);
			playInfoVO.setFileName("测试问题件");
			playInfoVOs.add(playInfoVO);
			playInfoVO = new OpenPlayInfoVO();
			playInfoVO.setVideoID(22);
			playInfoVO.setHashID("84ee07ff14e2d6b02d517b0c2d8152172baadbe0");
			playInfoVO.setDefinitionID(2);
			playInfoVO.setFileSize(200000);
			playInfoVO.setVedioTypeID(10);
			playInfoVO.setFileName("风行");
			playInfoVOs.add(playInfoVO);
			//
			PlayInfoOPResult playInfoResult = client.addPlayInfos(playInfoVOs);
			System.out.println("testGetInfoByVideoID:" + playInfoResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public void testUpdatePlayInfos() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);
			List<OpenPlayInfoVO> playInfoVOs = new ArrayList<OpenPlayInfoVO>();
			OpenPlayInfoVO playInfoVO = new OpenPlayInfoVO();
			playInfoVO.setPlayID(59);
			playInfoVOs.add(playInfoVO);
			playInfoVO = new OpenPlayInfoVO();
			playInfoVO.setPlayID(60);
			playInfoVOs.add(playInfoVO);
			//
			PlayInfoOPResult playInfoResult = client
					.updatePlayInfos(playInfoVOs);
			System.out.println("testGetInfoByVideoID:" + playInfoResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public void _testAddFileType() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);
			List<FileTypeVO> fileTypeVOs = new ArrayList<FileTypeVO>();
			FileTypeVO fileTypeVO = new FileTypeVO();
			fileTypeVO.setFileCode("H263_mp4");
			fileTypeVO.setFileName("H263_mp4");
			fileTypeVOs.add(fileTypeVO);
			fileTypeVO = new FileTypeVO();
			fileTypeVO.setFileCode("H264_mp4");
			fileTypeVO.setFileName("H264_mp4");
			fileTypeVOs.add(fileTypeVO);
			//
			FileTypeOPResult fileTypeResult = client.addFileTypes(fileTypeVOs);
			System.out.println("testAddFileType:" + fileTypeResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public void testUpdateFileType() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);
			List<FileTypeVO> fileTypeVOs = new ArrayList<FileTypeVO>();
			FileTypeVO fileTypeVO = new FileTypeVO();
			fileTypeVO.setFileTypeID(49);
			fileTypeVO.setFileCode("test_mobile");
			fileTypeVOs.add(fileTypeVO);
			fileTypeVO = new FileTypeVO();
			fileTypeVO.setFileTypeID(51);
			fileTypeVO.setFileCode("test_H263_mp4");
			fileTypeVOs.add(fileTypeVO);
			//
			FileTypeOPResult fileTypeResult = client
					.updateFileTypes(fileTypeVOs);
			System.out.println("testUpdateFileType:" + fileTypeResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public void _testAddDefinition() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);
			List<DefinitionVO> fileTypeVOs = new ArrayList<DefinitionVO>();
			DefinitionVO difiationVO = new DefinitionVO();
			difiationVO.setDefCode("dvd");
			difiationVO.setDefName("dvd");
			fileTypeVOs.add(difiationVO);
			difiationVO = new DefinitionVO();
			difiationVO.setDefCode("sdvd");
			difiationVO.setDefName("sdvd");
			fileTypeVOs.add(difiationVO);
			//
			DefinitionOPResult definiationResult = client
					.addDefinitions(fileTypeVOs);
			System.out.println("testAddDefinition:" + definiationResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public void testUpdateDefinition() {
		try {
			socket.open();
			TFramedTransport trans = new TFramedTransport(socket);
			TProtocol protocol = new TBinaryProtocol(trans);
			TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,
					IRPCServiceName.OPEN_PLAY_INFO_OP_SERVICE);
			OpenPlayInfoOpService.Client client = new OpenPlayInfoOpService.Client(
					mp1);
			List<DefinitionVO> definiationVOs = new ArrayList<DefinitionVO>();
			DefinitionVO difiationVO = new DefinitionVO();
			difiationVO.setDefinitionID(54);
			difiationVO.setDefCode("test_phone");
			definiationVOs.add(difiationVO);
			difiationVO = new DefinitionVO();
			difiationVO.setDefinitionID(56);
			difiationVO.setDefCode("test_dvd");
			definiationVOs.add(difiationVO);
			//
			DefinitionOPResult definiationResult = client
					.updateDefinitions(definiationVOs);
			System.out.println("testUpdateDefinition:" + definiationResult);
			socket.close();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}
