package com.fun.playctrl.dest.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:AreaType <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:48:38 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class AreaTypeVO implements BaseVO {

	private int areaTypeID;
	private String areaTypeName;
	private String description;

	public int getAreaTypeID() {
		return areaTypeID;
	}

	public void setAreaTypeID(int areaTypeID) {
		this.areaTypeID = areaTypeID;
	}

	public String getAreaTypeName() {
		return areaTypeName;
	}

	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String geyTableName() {
		return "fun_area_type";

	}

	@Override
	public String geyPrimaryKey() {
		return null;

	}

}
