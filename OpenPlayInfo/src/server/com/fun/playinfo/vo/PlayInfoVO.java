package com.fun.playinfo.vo;

/**
 * 播放信息VO<br/>
 * Date: 2014-9-4 下午1:32:35 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class PlayInfoVO implements BaseVO {

	private Integer play_id;
	private Integer video_id;
	private Integer definition_id;
	private Integer ftype_id;
	private String info_hash;
	private Integer file_name;
	private Long file_size;
	private Integer disable;
	private Integer create_time;
	private Integer update_time;

	
	
	public Integer getPlay_id() {
		return play_id;
	}

	public void setPlay_id(Integer play_id) {
		this.play_id = play_id;
	}

	public Integer getVideo_id() {
		return video_id;
	}

	public void setVideo_id(Integer video_id) {
		this.video_id = video_id;
	}

	public Integer getDefinition_id() {
		return definition_id;
	}

	public void setDefinition_id(Integer definition_id) {
		this.definition_id = definition_id;
	}

	public Integer getFtype_id() {
		return ftype_id;
	}

	public void setFtype_id(Integer ftype_id) {
		this.ftype_id = ftype_id;
	}

	public String getInfo_hash() {
		return info_hash;
	}

	public void setInfo_hash(String info_hash) {
		this.info_hash = info_hash;
	}

	public Integer getFile_name() {
		return file_name;
	}

	public void setFile_name(Integer file_name) {
		this.file_name = file_name;
	}

	public Long getFile_size() {
		return file_size;
	}

	public void setFile_size(Long file_size) {
		this.file_size = file_size;
	}

	public Integer getDisable() {
		return disable;
	}

	public void setDisable(Integer disable) {
		this.disable = disable;
	}

	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}

	public Integer getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Integer update_time) {
		this.update_time = update_time;
	}

	@Override
	public String geyTableName() {
		return "fun_video_play";
	}

	@Override
	public String geyPrimaryKey() {
		return "play_id";
	}

}
