package com.fun.playctrl.src.vo;

import java.util.Date;

import com.fun.playctrl.common.vo.BaseVO;

/**
 * ClassName:MediaAreaTaticRelaVO <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午3:53:13 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class MediaAreaTaticRelaVO implements BaseVO {

	private int mediaID;
	private int tactic;
	private String client;
	private Date version;

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public int getTactic() {
		return tactic;
	}

	public void setTactic(int tactic) {
		this.tactic = tactic;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	@Override
	public String geyTableName() {

		return "fs_media_area_tactic_relation";

	}

	@Override
	public String geyPrimaryKey() {

		// TODO Auto-generated method stub
		return null;

	}

}
