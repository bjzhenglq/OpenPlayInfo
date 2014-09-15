package com.fun.playctrl.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.fun.mybatis.dao.BaseDao;
import com.fun.playctrl.constant.Contants;
import com.fun.playctrl.dest.vo.AreaTypeVO;
import com.fun.playctrl.dest.vo.ClientTypeVO;
import com.fun.playctrl.dest.vo.GalleryClientVO;
import com.fun.playctrl.mapper.DestAreaTypeMapper;
import com.fun.playctrl.mapper.DestClientTypeMapper;
import com.fun.playctrl.mapper.DestGalleryAreaTaticMapper;
import com.fun.playctrl.mapper.DestGalleryClientMapper;
import com.fun.playctrl.mapper.SrcMediaAreaTaticMapper;
import com.fun.playctrl.mapper.SrcMediaClientMapper;
import com.fun.playctrl.src.vo.MediaAreaTaticRelaVO;
import com.fun.playctrl.src.vo.MediaClientVO;

/**
 * ClassName:TransferDataService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:35:17 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class TransferDataService extends BaseDao {

	int pageSize = 1000;
	int beginNum = 1;
	int curPage = 0;

	public void transfer() {
		// initData();
		transferMediaClient();
		transferMediaTaticRela();

	}

	/**
	 * 
	 * 传输媒体关系信息<br/>
	 * 
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void transferMediaTaticRela() {
		int totalSize = 654100;
		SqlSession session = getSessionFactory(false).openSession();
		SrcMediaAreaTaticMapper mediaMapper = session
				.getMapper(SrcMediaAreaTaticMapper.class);
		SqlSession destSession = getSessionFactory(true).openSession(
				ExecutorType.BATCH, true);
		DestGalleryAreaTaticMapper destMapper = destSession
				.getMapper(DestGalleryAreaTaticMapper.class);

		for (int curPage = 0; curPage <= Math.ceil(totalSize / pageSize); curPage++) {
			beginNum = curPage * pageSize;
			List<MediaAreaTaticRelaVO> mediaList = mediaMapper
					.selectAreaTaticRela(beginNum, pageSize);
			if (mediaList != null && mediaList.size() > 0) {
			}
		}
		session.close();
		destSession.close();
	}

	/**
	 * 传输媒体客户端信息 <br/>
	 * 
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void transferMediaClient() {
		int totalSize = 230592;
		SqlSession session = getSessionFactory(false).openSession();
		SrcMediaClientMapper mapper = session
				.getMapper(SrcMediaClientMapper.class);
		SqlSession destSession = getSessionFactory(true).openSession(
				ExecutorType.BATCH, true);
		DestGalleryClientMapper destMapper = destSession
				.getMapper(DestGalleryClientMapper.class);
		for (int curPage = 0; curPage <= Math.ceil(totalSize / pageSize); curPage++) {
			beginNum = curPage * pageSize;
			List<MediaClientVO> mediaList = mapper.selectMediaClient(beginNum,
					pageSize);
			if (mediaList != null && mediaList.size() > 0) {
				List<GalleryClientVO> galleryClientVOList = new ArrayList<GalleryClientVO>();
				for (MediaClientVO mediaClientVO : mediaList) {
					GalleryClientVO galleryClientVO = new GalleryClientVO();
					galleryClientVO.setGallaryID(mediaClientVO.getMediaID());
					galleryClientVO.setClientTypeID(Contants.clientTypeMap
							.get(mediaClientVO.getClient()));
					galleryClientVO.setDisplay(mediaClientVO.isDisPlay());
					galleryClientVO
							.setClientTime(mediaClientVO.getCreateTime());
					galleryClientVO
							.setUpdateTime(mediaClientVO.getUpdateTime());
					galleryClientVOList.add(galleryClientVO);
				}
				try {
					destMapper.insertGalleryClientList(galleryClientVOList);
					destSession.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		destSession.close();
		session.close();
	}

	/**
	 * 数据初始化 <br/>
	 * 
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void initData() {
		initAreaTypeData();
		// initAreaData();
		initClientTypeData();
	}

	/**
	 * 预置地区类型 <br/>
	 * 
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void initAreaTypeData() {
		SqlSession session = getSessionFactory(true).openSession();
		DestAreaTypeMapper areaTypeMapper = session
				.getMapper(DestAreaTypeMapper.class);
		List<AreaTypeVO> areaTypeList = new ArrayList<AreaTypeVO>();
		AreaTypeVO areaTypeVO = new AreaTypeVO();
		areaTypeVO.setAreaTypeID(1);
		areaTypeVO.setAreaTypeName("city");
		areaTypeVO.setDescription("地区级市");
		areaTypeList.add(areaTypeVO);

		areaTypeVO = new AreaTypeVO();
		areaTypeVO.setAreaTypeID(2);
		areaTypeVO.setAreaTypeName("province");
		areaTypeVO.setDescription("省/市/自治区");
		areaTypeList.add(areaTypeVO);

		areaTypeVO = new AreaTypeVO();
		areaTypeVO.setAreaTypeID(3);
		areaTypeVO.setAreaTypeName("country");
		areaTypeVO.setDescription("国家");
		areaTypeList.add(areaTypeVO);

		areaTypeVO = new AreaTypeVO();
		areaTypeVO.setAreaTypeID(4);
		areaTypeVO.setAreaTypeName("area");
		areaTypeVO.setDescription("地区(如台湾、香港...)");
		areaTypeList.add(areaTypeVO);

		for (AreaTypeVO areaType : areaTypeList) {
			areaTypeMapper.insertAreaType(areaType);
		}
		session.close();
	}

	/**
	 * 
	 * 预置客户端类型数据 <br/>
	 * 
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	private void initClientTypeData() {
		SqlSession session = getSessionFactory(true).openSession();
		DestClientTypeMapper clientTypeMapper = session
				.getMapper(DestClientTypeMapper.class);
		List<ClientTypeVO> clientTypeList = new ArrayList<ClientTypeVO>();
		ClientTypeVO clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("1");
		clientTypeVO.setClientTypeName("apad");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("2");
		clientTypeVO.setClientTypeName("aphone");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("3");
		clientTypeVO.setClientTypeName("ipad");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("4");
		clientTypeVO.setClientTypeName("iphone");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("5");
		clientTypeVO.setClientTypeName("mweb");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("6");
		clientTypeVO.setClientTypeName("ott");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("7");
		clientTypeVO.setClientTypeName("pc");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("8");
		clientTypeVO.setClientTypeName("third_part");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("9");
		clientTypeVO.setClientTypeName("web");
		clientTypeList.add(clientTypeVO);

		clientTypeVO = new ClientTypeVO();
		clientTypeVO.setClientTypeID("10");
		clientTypeVO.setClientTypeName("winphone");
		clientTypeList.add(clientTypeVO);
		for (ClientTypeVO clientType : clientTypeList) {
			clientTypeMapper.insertClientType(clientType);
		}
		session.close();

	}

	@Override
	public void close() throws IOException {

	}
	// private void initAreaData() {
	// SqlSession session = destSessionFactory.openSession();
	// DestAreaMapper areaMapper = session.getMapper(DestAreaMapper.class);
	// AreaVO areaVO = new AreaVO();
	// areaVO.setAreaID(1);
	// areaVO.setAreaTypeID(areaTypeID);
	// areaVO.setName(name);
	// areaVO.setCreateTime(createTime);
	// areaVO.setUpdateTime(updateTime);
	// areaVO.setAreaTypeID(areaTypeID);
	// areaMapper.insertArea(areaVO);
	// DestAreaTypeMapper areaTypeMapper = session
	// .getMapper(DestAreaTypeMapper.class);
	// DestClientTypeMapper clientTypeMapper = session
	// .getMapper(DestClientTypeMapper.class);
	// }

}
