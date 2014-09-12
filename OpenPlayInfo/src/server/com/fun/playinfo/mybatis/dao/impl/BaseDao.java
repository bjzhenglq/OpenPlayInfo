package com.fun.playinfo.mybatis.dao.impl;

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
public class BaseDao {
	protected static SqlSessionFactory sessionFactory = null;

	static {
		sessionFactory = MyBatisHelper.getSQlSessionFactory();
	}
}
