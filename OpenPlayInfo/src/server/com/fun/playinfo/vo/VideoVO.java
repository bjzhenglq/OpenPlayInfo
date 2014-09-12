package com.fun.playinfo.vo;

/**
 * 视频信息VO <br/>
 * Date: 2014-9-4 下午1:34:15 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class VideoVO implements BaseVO {

	@Override
	public String geyTableName() {
		return "fun_video";

	}

	@Override
	public String geyPrimaryKey() {
		return "video_id";

	}

}
