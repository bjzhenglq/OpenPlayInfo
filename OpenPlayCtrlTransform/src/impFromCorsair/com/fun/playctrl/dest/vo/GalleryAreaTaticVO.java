package com.fun.playctrl.dest.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:GalleryAreaTaticVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:46:30 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class GalleryAreaTaticVO implements BaseVO {

	private int gallaryID;
	private int areaID;
	private int clientTypeID;
	private boolean deleted;
	private int clientTime;
	private int updateTime;

	public int getGallaryID() {
		return gallaryID;
	}

	public void setGallaryID(int gallaryID) {
		this.gallaryID = gallaryID;
	}

	public int getAreaID() {
		return areaID;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public int getClientTypeID() {
		return clientTypeID;
	}

	public void setClientTypeID(int clientTypeID) {
		this.clientTypeID = clientTypeID;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getClientTime() {
		return clientTime;
	}

	public void setClientTime(int clientTime) {
		this.clientTime = clientTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String geyTableName() {
		return "fun_gallary_area_tactic";

	}

	@Override
	public String geyPrimaryKey() {

		return null;

	}

}
