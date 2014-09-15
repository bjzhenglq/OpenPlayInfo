package com.fun.playctrl.src.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:MediaVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:51:18 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class MediaVO implements BaseVO {

	private int mediaID;
	private String nameCN;

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	@Override
	public String geyTableName() {
		return "fs_media";

	}

	@Override
	public String geyPrimaryKey() {
		return null;

	}

}
