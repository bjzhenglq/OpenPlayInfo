package com.fun.playctrl.dest.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:ClientTypeVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:49:07 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class ClientTypeVO implements BaseVO {

	private String clientTypeID;
	private String clientTypeName;

	public String getClientTypeID() {
		return clientTypeID;
	}

	public void setClientTypeID(String clientTypeID) {
		this.clientTypeID = clientTypeID;
	}

	public String getClientTypeName() {
		return clientTypeName;
	}

	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}

	@Override
	public String geyTableName() {
		return "fun_client_type";

	}

	@Override
	public String geyPrimaryKey() {
		return null;

	}

}
