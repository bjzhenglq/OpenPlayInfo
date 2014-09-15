package com.fun.mybatis.dao;

import java.io.Closeable;

import org.apache.ibatis.session.SqlSessionFactory;

import com.fun.playinfo.utils.MyBatisHelper;

/**
 * ClassName:BaseService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-5 下午2:09:20 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public abstract class BaseDao implements Closeable {
	private static SqlSessionFactory readSessionFactory = null;
	private static SqlSessionFactory writeSessionFactory = null;

	static {
		writeSessionFactory = MyBatisHelper.getWriteSessionFactory();
		readSessionFactory = MyBatisHelper.getReadSessionFactory();
	}

	public SqlSessionFactory getSessionFactory(boolean writeAble) {
		if (writeAble) {
			return writeSessionFactory;
		} else {
			return readSessionFactory;
		}
	}
}
