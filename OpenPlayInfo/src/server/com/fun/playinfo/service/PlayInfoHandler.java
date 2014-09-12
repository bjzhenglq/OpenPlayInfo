/**
 * Project Name:OpenPlayInfo
 * File Name:PlayInfoHandler.java
 * Package Name:com.fun.playinfo.service
 * Date:2014-9-11下午3:23:29
 * Copyright (c) 2014, zhenglq@fun.tv All Rights Reserved.
 *
 */

package com.fun.playinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fun.playinfo.mybatis.dao.IPlayInfoDao;
import com.fun.playinfo.mybatis.dao.impl.PlayInfoDaoImpl;
import com.fun.playinfo.thrift.OpenPlayInfoVO;
import com.fun.playinfo.utils.LogHelper;

/**
 * ClassName:PlayInfoHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-11 下午3:23:29 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class PlayInfoHandler {

	private static PlayInfoHandler instance = null;
	// 视频为key，播放信息为value
	private final ConcurrentHashMap<Integer, List<OpenPlayInfoVO>> vedioIDMap;
	// 视频为key，播放信息为value
	private final ConcurrentHashMap<Integer, OpenPlayInfoVO> playIDMap;
	// hashID为key，播放信息为value
	private final ConcurrentHashMap<String, List<OpenPlayInfoVO>> hashIDMap;
	// hashID+playID为key，播放信息为value
	private final ConcurrentHashMap<String, List<OpenPlayInfoVO>> hashVedioIDMap;

	private IPlayInfoDao playInfoDao = null;

	private final int pageSize = 5000;

	private LogHelper log = null;

	private PlayInfoHandler() {
		vedioIDMap = new ConcurrentHashMap<Integer, List<OpenPlayInfoVO>>();
		playIDMap = new ConcurrentHashMap<Integer, OpenPlayInfoVO>();
		hashIDMap = new ConcurrentHashMap<String, List<OpenPlayInfoVO>>();
		hashVedioIDMap = new ConcurrentHashMap<String, List<OpenPlayInfoVO>>();
		playInfoDao = new PlayInfoDaoImpl();
		log = new LogHelper("PlayInfoHandler");
	}

	/**
	 * 获取数据处理对象，保证单例 <br/>
	 * 
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public static PlayInfoHandler getInstance() {
		if (instance == null) {
			synchronized (PlayInfoHandler.class) {
				if (instance == null) {
					instance = new PlayInfoHandler();
				}
			}
		}
		return instance;
	}

	public void initMemoryData() {
		int beginNum = 0;

		try {
			int totalNum = playInfoDao.getPlayInfoTotalNum();
			totalNum = 100;
			for (int curPage = 0; curPage <= totalNum / pageSize; curPage++) {
				beginNum = curPage * pageSize;
				List<OpenPlayInfoVO> playInfoList = playInfoDao
						.getPlayInfoByPageInfo(beginNum, pageSize);
				if (playInfoList != null) {
					for (OpenPlayInfoVO openPlayInfoVO : playInfoList) {
						// 初始化vedioMap
						int vedioID = openPlayInfoVO.getVideoID();
						List<OpenPlayInfoVO> vedioList = vedioIDMap
								.get(vedioID);
						if (vedioList == null) {
							vedioList = new ArrayList<OpenPlayInfoVO>();
						}
						vedioList.add(openPlayInfoVO);
						vedioIDMap.put(vedioID, vedioList);

						// 初始化playIDMap
						playIDMap.put(openPlayInfoVO.getPlayID(),
								openPlayInfoVO);

						// 初始化hashIDMap
						String hashID = openPlayInfoVO.getHashID();
						List<OpenPlayInfoVO> hashList = hashIDMap.get(hashID);
						if (hashList == null) {
							hashList = new ArrayList<OpenPlayInfoVO>();
						}
						hashList.add(openPlayInfoVO);
						hashIDMap.put(hashID, hashList);

						// 初始化hashVedioIDMap
						String hashVedioKey = hashID + "_" + vedioID;
						List<OpenPlayInfoVO> hashVedioList = hashVedioIDMap
								.get(hashVedioKey);
						if (hashVedioList == null) {
							hashVedioList = new ArrayList<OpenPlayInfoVO>();
						}
						hashVedioList.add(openPlayInfoVO);
						hashVedioIDMap.put(hashVedioKey, hashVedioList);
					}
				}
			}
			log.error("total init data number is %d", totalNum);
			Runtime currRuntime = Runtime.getRuntime();
			int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
			int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
			log.error(
					"total memory is %d,free memory is %d,and used memory is %d",
					nTotalMemory, nFreeMemory, nTotalMemory - nFreeMemory);
		} catch (Exception e) {
			log.equals(e);
		} finally {
		}
	}

	/**
	 * 定时从数据库中刷新数据，更新内存 <br/>
	 * 
	 * @param lastUpdteTime
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updateMemoryData(int lastUpdteTime) {
		try {
			List<OpenPlayInfoVO> uptList = playInfoDao
					.getPlayInfoByUptime(lastUpdteTime);
			if (uptList != null && uptList.size() > 0) {
				update2Memory(uptList);
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 从内存中删除数据 <br/>
	 * 
	 * @param uptList
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void deleteFromMemory(List<OpenPlayInfoVO> uptList) {
		for (OpenPlayInfoVO openPlayInfoVO : uptList) {
			int vedioID = openPlayInfoVO.getVideoID();
			List<OpenPlayInfoVO> vedioPlayInfoList = vedioIDMap.get(vedioID);
			if (vedioPlayInfoList != null) {
				vedioPlayInfoList.remove(openPlayInfoVO);
				vedioIDMap.put(vedioID, vedioPlayInfoList);
			}

			int playID = openPlayInfoVO.getPlayID();
			playIDMap.remove(playID);

			String hashID = openPlayInfoVO.getHashID();
			List<OpenPlayInfoVO> hashPlayInfoList = hashIDMap.get(hashID);
			// 如果是新增加的vedio信息，则直接添加
			if (hashPlayInfoList != null) {
				hashPlayInfoList.remove(openPlayInfoVO);
				hashIDMap.put(hashID, hashPlayInfoList);
			}

			String hashVedioKey = hashID + "_" + vedioID;
			List<OpenPlayInfoVO> hashVedioPlayInfoList = hashVedioIDMap
					.get(hashVedioKey);
			// 如果是新增加的vedio信息，则直接添加
			if (hashVedioPlayInfoList != null) {
				hashVedioPlayInfoList.remove(openPlayInfoVO);
				hashVedioIDMap.put(hashVedioKey, hashVedioPlayInfoList);
			}
		}
	}

	/**
	 * 将数据刷到内存中 <br/>
	 * 
	 * @param uptList
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void update2Memory(List<OpenPlayInfoVO> uptList) {
		for (OpenPlayInfoVO openPlayInfoVO : uptList) {
			int vedioID = openPlayInfoVO.getVideoID();
			List<OpenPlayInfoVO> vedioPlayInfoList = vedioIDMap.get(vedioID);
			// 如果是新增加的vedio信息，则直接添加
			if (vedioPlayInfoList == null) {
				vedioPlayInfoList = new ArrayList<OpenPlayInfoVO>();
			} else {
				// 如果原对象存在，则先删除，然后添加
				if (vedioPlayInfoList.contains(openPlayInfoVO)) {
					vedioPlayInfoList.remove(openPlayInfoVO);
				}
			}
			vedioPlayInfoList.add(openPlayInfoVO);
			vedioIDMap.put(vedioID, vedioPlayInfoList);
			// playMap数据直接更新
			int playID = openPlayInfoVO.getPlayID();
			playIDMap.put(playID, openPlayInfoVO);

			String hashID = openPlayInfoVO.getHashID();
			List<OpenPlayInfoVO> hashPlayInfoList = hashIDMap.get(hashID);
			// 如果是新增加的vedio信息，则直接添加
			if (hashPlayInfoList == null) {
				hashPlayInfoList = new ArrayList<OpenPlayInfoVO>();
			} else {
				// 如果原对象存在，则先删除，然后添加
				if (hashPlayInfoList.contains(openPlayInfoVO)) {
					hashPlayInfoList.remove(openPlayInfoVO);
				}
			}
			hashPlayInfoList.add(openPlayInfoVO);
			hashIDMap.put(hashID, hashPlayInfoList);

			String hashVedioKey = hashID + "_" + vedioID;
			List<OpenPlayInfoVO> hashVedioPlayInfoList = hashVedioIDMap
					.get(hashVedioKey);
			// 如果是新增加的vedio信息，则直接添加
			if (hashVedioPlayInfoList == null) {
				hashVedioPlayInfoList = new ArrayList<OpenPlayInfoVO>();
			} else {
				// 如果原对象存在，则先删除，然后添加
				if (hashVedioPlayInfoList.contains(openPlayInfoVO)) {
					hashVedioPlayInfoList.remove(openPlayInfoVO);
				}
			}
			hashVedioPlayInfoList.add(openPlayInfoVO);
			hashVedioIDMap.put(hashVedioKey, hashVedioPlayInfoList);
		}
	}

	public List<OpenPlayInfoVO> getInfoByVideoID(int videoID) {
		return vedioIDMap.get(videoID);
	}

	public OpenPlayInfoVO getInfoByPlayID(Integer playID) {
		return playIDMap.get(playID);

	}

	public List<OpenPlayInfoVO> getInfoByHashID(String hashID) {
		return hashIDMap.get(hashID);

	}

}
