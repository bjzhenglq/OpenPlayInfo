package com.fun.playctrl.src.vo;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:MediaClientVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:29:47 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class MediaClientVO implements BaseVO {

	private int mediaID;
	private String client;
	private boolean isPlay;
	private boolean isDisPlay;
	private int updateTime;
	private int createTime;

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public boolean isPlay() {
		return isPlay;
	}

	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}

	public boolean isDisPlay() {
		return isDisPlay;
	}

	public void setDisPlay(boolean isDisPlay) {
		this.isDisPlay = isDisPlay;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	@Override
	public String geyTableName() {
		return "fs_media_client";
	}

	@Override
	public String geyPrimaryKey() {
		return null;
	}
}
