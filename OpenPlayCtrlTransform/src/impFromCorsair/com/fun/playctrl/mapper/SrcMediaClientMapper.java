/**
 * Project Name:OpenPlayCtrl
 * File Name:DestAreaMapper.java
 * Package Name:com.fun.playctrl.mapper
 * Date:2014-9-9下午4:05:42
 * Copyright (c) 2014, zhenglq@fun.tv All Rights Reserved.
 *
 */

package com.fun.playctrl.mapper;

import java.util.List;

import com.fun.playctrl.src.vo.MediaClientVO;

/**
 * ClassName:DestAreaMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午4:05:42 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public interface SrcMediaClientMapper {

	public List<MediaClientVO> selectMediaClient(int beginNum, int pageSize);
}
