package com.fun.playinfo.mybatis.dao.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;

import com.fun.mybatis.dao.BaseDao;
import com.fun.playinfo.mybatis.dao.IPlayInfoDao;
import com.fun.playinfo.thrift.DefinitionVO;
import com.fun.playinfo.thrift.FileTypeVO;
import com.fun.playinfo.thrift.OpenPlayInfoVO;

/**
 * 播放信息持久层服务 <br/>
 * Date: 2014-9-11 上午10:57:08 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class PlayInfoDaoImpl extends BaseDao implements IPlayInfoDao {

	/**
	 * 根据视频ID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByVideoID(int)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByVideoID(int videoID) throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByVideoID(videoID);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据视频ID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByVideoIDList(java.util.List)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByVideoIDList(List<Integer> videoIDs)
			throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByVideoIDList(videoIDs);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据播放信息ID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByPlayIDList(java.util.List)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByPlayIDList(List<Integer> playIDs)
			throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByPlayIDList(playIDs);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据hashID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByHashID(java.lang.String)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByHashID(String hashID) throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByHashID(hashID);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据hashIDID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByHashIDList(java.util.List)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByHashIDList(List<String> hashIDs)
			throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByHashIDList(hashIDs);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据视频ID，hashID返回视频信息<br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getInfoByVideoANDHashIDList(java.util.HashMap)
	 */
	@Override
	public List<OpenPlayInfoVO> getInfoByVideoANDHashIDList(
			HashMap<String, List> infoMap) {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getInfoByVideoANDHashIDList(infoMap);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;
	}

	/**
	 * 根据主键查询清晰度 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getDefinitionByID(java.lang.String)
	 */
	@Override
	public DefinitionVO getDefinitionByID(String definitionID) {
		DefinitionVO definition = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			definition = dao.getDefinitionByID(definitionID);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return definition;
	}

	/**
	 * 根据主键查询清晰度 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getFileTypeByID(java.lang.String)
	 */
	@Override
	public FileTypeVO getFileTypeByID(String fileTypeID) {
		FileTypeVO fileTypeVO = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			fileTypeVO = dao.getFileTypeByID(fileTypeID);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return fileTypeVO;
	}

	/**
	 * 新增播放信息 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#addPlayInfo(com.fun.playinfo.thrift.OpenPlayInfoVO)
	 */
	@Override
	public void addPlayInfo(OpenPlayInfoVO playInfoVO) throws Exception {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			dao.addPlayInfo(playInfoVO);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 新增播放信息 .
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#addPlayInfoList(java.util.List)
	 */
	@Override
	public void addPlayInfoList(List<OpenPlayInfoVO> playInfoList)
			throws Exception {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			dao.addPlayInfoList(playInfoList);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 
	 * 更新播放信息.
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#updatePlayInfo(com.fun.playinfo.thrift.OpenPlayInfoVO)
	 */
	@Override
	public void updatePlayInfo(OpenPlayInfoVO playInfo) throws Exception {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession();
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfo.setUpdateTime((int) (System.currentTimeMillis() / 1000));
			dao.updatePlayInfo(playInfo);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 更新播放信息.
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#updatePlayInfos(java.util.List)
	 */
	@Override
	public void updatePlayInfos(List<OpenPlayInfoVO> params) throws Exception {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			for (OpenPlayInfoVO openPlayInfoVO : params) {
				dao.updatePlayInfo(openPlayInfoVO);
			}
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 删除播放信息
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#delPlayInfoByVedioID(java.lang.String)
	 */
	@Override
	public void delPlayInfoByVedioID(String vedioID) throws Exception {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			dao.delPlayInfoByVedioID(vedioID);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean canPlay(String galleryID) throws Exception {

		return false;

	}

	/**
	 * 
	 * description.
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getPlayInfoByPageInfo(int,
	 *      int)
	 */
	@Override
	public List<OpenPlayInfoVO> getPlayInfoByPageInfo(int curPage, int pageSize)
			throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getPlayInfoByPageInfo(curPage, pageSize);
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return playInfoList;

	}

	/**
	 * 获取上次更新后的所有变更的数据
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getPlayInfoByUptime(int)
	 */
	@Override
	public List<OpenPlayInfoVO> getPlayInfoByUptime(int lastUpdateTime)
			throws Exception {
		List<OpenPlayInfoVO> playInfoList = null;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			playInfoList = dao.getPlayInfoByUptime(lastUpdateTime);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return playInfoList;

	}

	/**
	 * 获取播放信息总数 .
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IPlayInfoDao#getPlayInfoTotalNum()
	 */
	@Override
	public int getPlayInfoTotalNum() throws Exception {
		int totalRow = 0;
		SqlSession session = null;
		try {
			session = getSessionFactory(false).openSession(ExecutorType.BATCH);
			IPlayInfoDao dao = session.getMapper(IPlayInfoDao.class);
			totalRow = dao.getPlayInfoTotalNum();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return totalRow;

	}

	@Override
	public void close() throws IOException {

		// TODO Auto-generated method stub

	}

}
