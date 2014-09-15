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
	private SqlSessionFactory readSessionFactory = null;
	private SqlSessionFactory writeSessionFactory = null;
	private final String resource = "mybatis-config.xml";

	private MyBatisHelper() {
		init();
	}

	private void init() {
		Reader readReader = null;
		Reader writeReader = null;
		try {
			readReader = Resources.getResourceAsReader(resource);
			writeReader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		readSessionFactory = new SqlSessionFactoryBuilder().build(readReader,
				"read");
		writeSessionFactory = new SqlSessionFactoryBuilder().build(writeReader,
				"write");
	}

	/**
	 * ��ȡ��ȡSqlSessionFactoryʵ��<br/>
	 * 
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public static SqlSessionFactory getReadSessionFactory() {
		if (myBatisHelper == null) {
			myBatisHelper = new MyBatisHelper();
		}
		return myBatisHelper.readSessionFactory;
	}

	public static SqlSessionFactory getWriteSessionFactory() {
		if (myBatisHelper == null) {
			myBatisHelper = new MyBatisHelper();
		}
		return myBatisHelper.writeSessionFactory;
	}
}
