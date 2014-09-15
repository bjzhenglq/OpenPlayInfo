package com.fun.playinfo.service;

import java.util.List;

import org.apache.thrift.TException;

import com.fun.playinfo.mybatis.dao.IDefinitionDao;
import com.fun.playinfo.mybatis.dao.IFileTypeDao;
import com.fun.playinfo.mybatis.dao.IPlayInfoDao;
import com.fun.playinfo.mybatis.dao.impl.DefinitionDaoImpl;
import com.fun.playinfo.mybatis.dao.impl.FileTypeDaoImpl;
import com.fun.playinfo.mybatis.dao.impl.PlayInfoDaoImpl;
import com.fun.playinfo.thrift.DefinitionOPResult;
import com.fun.playinfo.thrift.DefinitionVO;
import com.fun.playinfo.thrift.FileTypeOPResult;
import com.fun.playinfo.thrift.FileTypeVO;
import com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface;
import com.fun.playinfo.thrift.OpenPlayInfoVO;
import com.fun.playinfo.thrift.PlayInfoOPResult;
import com.fun.playinfo.utils.CCHandler;
import com.fun.playinfo.utils.LogHelper;

/**
 * ClassName:OpenPlayInfoOPServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-4 ����2:00:03 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class OpenPlayInfoOPServiceImpl implements Iface {

	private final LogHelper log = new LogHelper("OpenPlayInfoOPServiceImpl");
	private final PlayInfoHandler handler = PlayInfoHandler.getInstance();

	/**
	 * 新增播放信息.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#addPlayInfos(java.util.List)
	 */
	@Override
	public PlayInfoOPResult addPlayInfos(List<OpenPlayInfoVO> playInfoList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "addPlayInfos";
		PlayInfoOPResult result = new PlayInfoOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (playInfoList != null && playInfoList.size() > 0) {
				IPlayInfoDao dao = new PlayInfoDaoImpl();
				if (playInfoList != null && playInfoList.size() > 0) {
					dao.addPlayInfoList(playInfoList);
				}
				handler.updateMemory();
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, playInfoList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;

	}

	/**
	 * 修改播放信息.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#updatePlayInfos(java.util.List)
	 */
	@Override
	public PlayInfoOPResult updatePlayInfos(List<OpenPlayInfoVO> playInfoList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "updatePlayInfos";
		PlayInfoOPResult result = new PlayInfoOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (playInfoList != null && playInfoList.size() > 0) {
				IPlayInfoDao dao = new PlayInfoDaoImpl();
				for (OpenPlayInfoVO openPlayInfoVO : playInfoList) {
					dao.updatePlayInfo(openPlayInfoVO);
				}
				// 将变更过的数据刷到内存中
				handler.updateMemory();
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, playInfoList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;
	}

	/**
	 * 新增文件类型信息.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#addFileTypes(java.util.List)
	 */
	@Override
	public FileTypeOPResult addFileTypes(List<FileTypeVO> fileTypeList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "addFileTypes";
		FileTypeOPResult result = new FileTypeOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (fileTypeList != null && fileTypeList.size() > 0) {
				IFileTypeDao dao = new FileTypeDaoImpl();
				dao.addFileTypeList(fileTypeList);
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, fileTypeList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;
	}

	/**
	 * 修改文件类信息.
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#updateFileTypes(java.util.List)
	 */
	@Override
	public FileTypeOPResult updateFileTypes(List<FileTypeVO> fileTypeList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "addFileTypes";
		FileTypeOPResult result = new FileTypeOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (fileTypeList != null && fileTypeList.size() > 0) {
				IFileTypeDao dao = new FileTypeDaoImpl();

				for (FileTypeVO fileInfoVO : fileTypeList) {
					dao.updateFileType(fileInfoVO);
				}
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, fileTypeList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;
	}

	/**
	 * 新增清晰度信息
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#addDefinitions(java.util.List)
	 */
	@Override
	public DefinitionOPResult addDefinitions(List<DefinitionVO> defList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "addDefinitions";
		DefinitionOPResult result = new DefinitionOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (defList != null && defList.size() > 0) {
				IDefinitionDao dao = new DefinitionDaoImpl();
				dao.addDefinitionList(defList);
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, defList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;
	}

	/**
	 * 修改清晰度信息
	 * 
	 * @see com.fun.playinfo.thrift.OpenPlayInfoOpService.Iface#updateDefinitions(java.util.List)
	 */
	@Override
	public DefinitionOPResult updateDefinitions(List<DefinitionVO> defList)
			throws TException {
		long t1 = System.nanoTime();
		String apiName = "updateDefinitions";
		DefinitionOPResult result = new DefinitionOPResult();
		result.retCode = 200;
		result.retMsg = "OK";
		try {
			if (defList != null && defList.size() > 0) {
				IDefinitionDao dao = new DefinitionDaoImpl();
				for (DefinitionVO definitionVO : defList) {
					dao.updateDefinition(definitionVO);
				}
			}
		} catch (Exception e) {
			result.retCode = 500;
			result.retMsg = e.getMessage();
			log.error("error service retCode %s, for query %s: %s",
					result.retCode, apiName, defList);
		} finally {
			if (result.retCode != 500) {
				CCHandler.addOk(apiName);
			} else {
				CCHandler.addErr(apiName);
			}
			long t2 = System.nanoTime();
			log.debug("excute method apiName cost %d time", t2 - t1);
		}
		return result;
	}

}
