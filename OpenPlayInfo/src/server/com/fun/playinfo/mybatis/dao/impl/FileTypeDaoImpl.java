package com.fun.playinfo.mybatis.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.thrift.TException;

import com.fun.mybatis.dao.BaseDao;
import com.fun.playinfo.mybatis.dao.IFileTypeDao;
import com.fun.playinfo.thrift.FileTypeVO;

/**
 * ClassName:FileTypeDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-11 上午10:56:38 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class FileTypeDaoImpl extends BaseDao implements IFileTypeDao {

	/**
	 * 新增文件类型 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IFileTypeDao#addFileType(com.fun.playinfo.thrift.FileTypeVO)
	 */
	@Override
	public void addFileType(FileTypeVO fileTypeVO) throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IFileTypeDao dao = session.getMapper(IFileTypeDao.class);
			dao.addFileType(fileTypeVO);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 新增文件类型 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IFileTypeDao#addFileTypeList(java.util.List)
	 */
	@Override
	public void addFileTypeList(List<FileTypeVO> fileTypeList)
			throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IFileTypeDao dao = session.getMapper(IFileTypeDao.class);
			dao.addFileTypeList(fileTypeList);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 
	 * 更新文件类型 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IFileTypeDao#updateFileType(com.fun.playinfo.thrift.FileTypeVO)
	 */
	@Override
	public void updateFileType(FileTypeVO fileType) throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IFileTypeDao dao = session.getMapper(IFileTypeDao.class);
			dao.updateFileType(fileType);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 更新文件类型 <br/>
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IFileTypeDao#updateFileTypes(java.util.List)
	 */
	@Override
	public void updateFileTypes(List<FileTypeVO> fileTypes) throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IFileTypeDao dao = session.getMapper(IFileTypeDao.class);
			dao.updateFileTypes(fileTypes);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void close() throws IOException {

		// TODO Auto-generated method stub

	}

}
