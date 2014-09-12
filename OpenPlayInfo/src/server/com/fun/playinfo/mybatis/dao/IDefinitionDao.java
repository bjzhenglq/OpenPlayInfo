package com.fun.playinfo.mybatis.dao;

import java.util.List;

import org.apache.thrift.TException;

import com.fun.playinfo.thrift.DefinitionVO;

/**
 * ClassName:PlayInfoOPMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-4 下午3:31:15 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public interface IDefinitionDao {

	/**
	 * 新增清晰度信息 <br/>
	 * 
	 * @param fileTypeVO
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addDefinition(DefinitionVO definition) throws TException;

	/**
	 * 
	 * 新增清晰度信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addDefinitionList(List<DefinitionVO> definitionList)
			throws TException;

	/**
	 * 更新清晰度信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updateDefinition(DefinitionVO definition) throws TException;

	/**
	 * 更新清晰度信息 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updateDefinitions(List<DefinitionVO> definitions)
			throws TException;
}
