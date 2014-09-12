package com.fun.playinfo.mybatis.dao;

import java.util.List;

import org.apache.thrift.TException;

import com.fun.playinfo.thrift.FileTypeVO;

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
public interface IFileTypeDao {

	/**
	 * 新增文件类型 <br/>
	 * 
	 * @param fileTypeVO
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addFileType(FileTypeVO fileTypeVO) throws TException;

	/**
	 * 
	 * 新增文件类型 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void addFileTypeList(List<FileTypeVO> fileTypeList)
			throws TException;

	/**
	 * 更新文件类型 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updateFileType(FileTypeVO fileType) throws TException;

	/**
	 * 更新文件类型 <br/>
	 * 
	 * @param params
	 * @return
	 * @throws TException
	 * @author zhenglq
	 * @since JDK 1.7
	 */
	public void updateFileTypes(List<FileTypeVO> fileTypes) throws TException;
}
