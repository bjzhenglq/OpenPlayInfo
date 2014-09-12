package com.fun.playinfo.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ClassName:AuthBaseService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-8-25 上午10:55:27 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class MyBatisHelper {

	private static MyBatisHelper myBatisHelper = null;
	private SqlSessionFactory sqlSessionFactory = null;
	private final String resource = "mybatis-config.xml";

	private MyBatisHelper() {
		init();
	}

	private void init() {
		Reader reader = null;
		try {
			// String classPath = getClass().getResource("/").getPath();
			// String filePath
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	/**
	 * ��ȡ��ȡSqlSessionFactoryʵ��<br/>
	 * 
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public static SqlSessionFactory getSQlSessionFactory() {
		if (myBatisHelper == null) {
			myBatisHelper = new MyBatisHelper();
		}
		return myBatisHelper.sqlSessionFactory;
	}
}
