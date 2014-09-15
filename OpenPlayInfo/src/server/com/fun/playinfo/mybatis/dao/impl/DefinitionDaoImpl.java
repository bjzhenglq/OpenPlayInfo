package com.fun.playinfo.mybatis.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.thrift.TException;

import com.fun.mybatis.dao.BaseDao;
import com.fun.playinfo.mybatis.dao.IDefinitionDao;
import com.fun.playinfo.thrift.DefinitionVO;

/**
 * ClassName:DefinitionDaoImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-11 上午10:45:05 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class DefinitionDaoImpl extends BaseDao implements IDefinitionDao {

	/**
	 * 新增清晰度信息 .
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IDefinitionDao#addDefinition(com.fun.playinfo.thrift.DefinitionVO)
	 */
	@Override
	public void addDefinition(DefinitionVO definition) throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IDefinitionDao definitionMapper = session
					.getMapper(IDefinitionDao.class);
			definitionMapper.addDefinition(definition);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 批量新增清晰度信息 .
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IDefinitionDao#addDefinitionList(java.util.List)
	 */
	@Override
	public void addDefinitionList(List<DefinitionVO> definitionList)
			throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IDefinitionDao definitionMapper = session
					.getMapper(IDefinitionDao.class);
			definitionMapper.addDefinitionList(definitionList);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 更新清晰度信息 .
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IDefinitionDao#updateDefinition(com.fun.playinfo.thrift.DefinitionVO)
	 */
	@Override
	public void updateDefinition(DefinitionVO definition) throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IDefinitionDao definitionMapper = session
					.getMapper(IDefinitionDao.class);
			definitionMapper.updateDefinition(definition);
			session.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 批量更新清晰度信息
	 * 
	 * @see com.fun.playinfo.mybatis.dao.IDefinitionDao#updateDefinitions(java.util.List)
	 */
	@Override
	public void updateDefinitions(List<DefinitionVO> definitions)
			throws TException {
		SqlSession session = null;
		try {
			session = getSessionFactory(true).openSession(ExecutorType.BATCH);
			IDefinitionDao definitionMapper = session
					.getMapper(IDefinitionDao.class);
			definitionMapper.updateDefinitions(definitions);
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
