package com.fun.playinfo.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import com.fun.playinfo.thrift.DefinitionVO;
import com.fun.playinfo.thrift.FileTypeVO;
import com.fun.playinfo.thrift.OpenPlayInfoVO;

/**
 * 播放信息Mapper <br/>
 * Date: 2014-9-4 下午3:30:38 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public interface IPlayInfoDao {

	/**
	 * 根据视频ID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getInfoByVideoID(int videoID) throws Exception;

	/**
	 * 根据视频ID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getInfoByVideoIDList(List<Integer> videoIDs)
			throws Exception;

	/**
	 * 根据播放信息ID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getInfoByPlayIDList(List<Integer> playIDs)
			throws Exception;

	/**
	 * 根据hashID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getInfoByHashID(String hashID) throws Exception;

	/**
	 * 根据hashIDID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getInfoByHashIDList(List<String> hashIDs)
			throws Exception;

	/**
	 * 根据视频ID，hashID返回视频信息<br/>
	 * 
	 * @param videoID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	@SuppressWarnings("rawtypes")
	public List<OpenPlayInfoVO> getInfoByVideoANDHashIDList(
			HashMap<String, List> infoMap);

	/**
	 * 根据主键查询清晰度 <br/>
	 * 
	 * @param definitionID
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public DefinitionVO getDefinitionByID(String definitionID);

	/**
	 * 根据主键查询清晰度 <br/>
	 * 
	 * @param definitionID
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public FileTypeVO getFileTypeByID(String fileTypeID);

	/**
	 * 新增播放信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addPlayInfo(OpenPlayInfoVO playInfoVO) throws Exception;

	/**
	 * 
	 * 新增播放信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addPlayInfoList(List<OpenPlayInfoVO> playInfoList)
			throws Exception;

	/**
	 * 更新播放信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updatePlayInfo(OpenPlayInfoVO playInfo) throws Exception;

	/**
	 * 更新播放信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updatePlayInfos(List<OpenPlayInfoVO> params) throws Exception;

	/**
	 * 
	 * 删除播放信息 <br/>
	 * 
	 * @param vedioID
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void delPlayInfoByVedioID(String vedioID) throws Exception;

	/**
	 * 根据GalleryID判断一个视频是否存在种子 <br/>
	 * 
	 * @param galleryID
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public boolean canPlay(String galleryID) throws Exception;

	/**
	 * 
	 * 分页抓取播放信息 <br/>
	 * 
	 * @param curPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getPlayInfoByPageInfo(int curPage, int pageSize)
			throws Exception;

	/**
	 * 获取播放信息总数 <br/>
	 * 
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public int getPlayInfoTotalNum() throws Exception;

	/**
	 * 获取上次更新后的所有变更的数据 <br/>
	 * 
	 * @param lastUpdateTime
	 * @return
	 * @throws Exception
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public List<OpenPlayInfoVO> getPlayInfoByUptime(int lastUpdateTime)
			throws Exception;
}
