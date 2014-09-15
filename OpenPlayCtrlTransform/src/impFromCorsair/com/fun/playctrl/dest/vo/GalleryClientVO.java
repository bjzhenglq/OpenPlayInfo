package com.fun.playctrl.dest.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:GalleryClientVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:45:08 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class GalleryClientVO implements BaseVO {

	private int gallaryID;
	private int clientTypeID;
	private boolean display;
	private int clientTime;
	private int updateTime;

	public int getGallaryID() {
		return gallaryID;
	}

	public void setGallaryID(int gallaryID) {
		this.gallaryID = gallaryID;
	}

	public int getClientTypeID() {
		return clientTypeID;
	}

	public void setClientTypeID(int clientTypeID) {
		this.clientTypeID = clientTypeID;
	}

	public boolean getDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
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
		return "fun_gallary_client";

	}

	@Override
	public String geyPrimaryKey() {
		return null;
	}

}
