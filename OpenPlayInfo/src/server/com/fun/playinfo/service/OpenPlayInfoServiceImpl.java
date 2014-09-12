package com.fun.playinfo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.thrift.TException;

import com.fun.playinfo.mybatis.dao.IPlayInfoDao;
import com.fun.playinfo.mybatis.dao.impl.PlayInfoDaoImpl;
import com.fun.playinfo.thrift.OpenPlayInfoService.Iface;
import com.fun.playinfo.thrift.OpenPlayInfoVO;
import com.fun.playinfo.thrift.PlayInfoVOResult;
import com.fun.playinfo.utils.CCHandler;
import com.fun.playinfo.utils.LogHelper;

/**
 * ClassName:OpenPlayInfoServiceImpl <br/>
 * Date: 2014-9-4 11:59:18 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class OpenPlayInfoServiceImpl implements Iface {

	private final LogHelper log = new LogHelper("OpenPlayInfoServiceImpl");
	private final PlayInfoHandler handler = PlayInfoHandler.getInstance();

	/**
	 * 
	 * 根据视频ID返回视频信息
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoService.Iface#getInfoByVideoID(int)
	 */
	@Override
	public PlayInfoVOResult getInfoByVideoID(int videoID) throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByVideoID";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			log.debug("%s: %s", apiName, videoID);
			// IPlayInfoDao playInfo = new PlayInfoDaoImpl();
			// result.infoList = playInfo.getInfoByVideoID(videoID);

			result.infoList = handler.getInfoByVideoID(videoID);
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, videoID);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	/**
	 * 根据视频ID返回视频信息.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoService.Iface#getInfoByVideoIDList(java.util.List)
	 */
	@Override
	public PlayInfoVOResult getInfoByVideoIDList(List<Integer> videoIDs)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByVideoIDList";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		result.infoList = new ArrayList<OpenPlayInfoVO>();
		try {
			log.debug("%s: %s", apiName, videoIDs);
			if (videoIDs != null && videoIDs.size() > 0) {
				// IPlayInfoDao playInfo = new PlayInfoDaoImpl();
				// result.infoList = playInfo.getInfoByVideoIDList(videoIDs);
				for (Integer videoID : videoIDs) {
					List<OpenPlayInfoVO> list = handler
							.getInfoByVideoID(videoID);
					if (list != null) {
						result.infoList.addAll(list);
					}
				}
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, videoIDs);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	@Override
	public PlayInfoVOResult getInfoByHashID(String hashID) throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByHashID";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			log.debug("%s: %s", apiName, hashID);
			if (hashID != null && hashID.length() > 0) {
				// IPlayInfoDao playInfo = new PlayInfoDaoImpl();
				// result.infoList = playInfo.getInfoByHashID(hashID);
				List<OpenPlayInfoVO> list = handler.getInfoByHashID(hashID);
				result.infoList = list;
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, hashID);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	@Override
	public PlayInfoVOResult getInfoByPlayIDList(List<Integer> playIDs)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByPlayIDList";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		result.infoList = new ArrayList<OpenPlayInfoVO>();
		try {
			log.debug("%s: %s", apiName, playIDs);
			if (playIDs != null && playIDs.size() > 0) {
				for (Integer playID : playIDs) {
					OpenPlayInfoVO playInfo = handler.getInfoByPlayID(playID);
					if (playInfo != null) {
						result.infoList.add(playInfo);
					}
				}
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, playIDs);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	@Override
	public PlayInfoVOResult getInfoByHashIDList(List<String> hashIDs)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByHashIDList";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		result.infoList = new ArrayList<OpenPlayInfoVO>();
		try {
			log.debug("%s: %s", apiName, hashIDs);
			if (hashIDs != null && hashIDs.size() > 0) {
				for (String hashID : hashIDs) {
					List<OpenPlayInfoVO> list = handler.getInfoByHashID(hashID);
					if (list != null) {
						result.infoList.addAll(list);
					}
				}
				// IPlayInfoDao playInfo = new PlayInfoDaoImpl();
				// result.infoList = playInfo.getInfoByHashIDList(hashIDs);
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, hashIDs);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	/**
	 * 
	 * description.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoService.Iface#getInfoByVideoANDHashIDList(java.util.List,
	 *      java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public PlayInfoVOResult getInfoByVideoANDHashIDList(List<Integer> videoIDs,
			List<String> hashIDs) throws TException {
		long t1 = System.nanoTime();
		String apiName = "getInfoByVideoANDHashIDList";
		PlayInfoVOResult result = new PlayInfoVOResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			log.debug("%s: %s，%s", apiName, videoIDs, hashIDs);
			if (videoIDs != null && videoIDs.size() > 0 && hashIDs != null
					&& hashIDs.size() > 0) {
				IPlayInfoDao playInfo = new PlayInfoDaoImpl();
				HashMap<String, List> infoMap = new HashMap<String, List>();
				infoMap.put("videoIDs", videoIDs);
				infoMap.put("hashIDs", hashIDs);
				result.infoList = playInfo.getInfoByVideoANDHashIDList(infoMap);
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, videoIDs);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}
}
