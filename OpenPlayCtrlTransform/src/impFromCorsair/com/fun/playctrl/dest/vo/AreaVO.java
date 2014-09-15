package com.fun.playctrl.dest.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:AreaVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:47:46 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class AreaVO implements BaseVO {

	private int areaID;
	private String name;
	private int areaTypeID;
	private boolean deleted;
	private int createTime;
	private int updateTime;

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAreaTypeID() {
		return areaTypeID;
	}

	public void setAreaTypeID(int areaTypeID) {
		this.areaTypeID = areaTypeID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String geyTableName() {
		return "fun_area";
	}

	@Override
	public String geyPrimaryKey() {
		return null;
	}

}
