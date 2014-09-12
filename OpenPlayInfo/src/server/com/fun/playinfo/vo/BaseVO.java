package com.fun.playinfo.vo;

/**
 * 数据对象基类. <br/>
 * Date: 2014-9-4 下午1:30:55 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public interface BaseVO {

	/**
	 * 返回表名称<br/>
	 * 
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public String geyTableName();

	/**
	 * 返回主键名称 <br/>
	 * 
	 * @return
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public String geyPrimaryKey();
}
