namespace java com.fun.playinfo.thrift



struct FileTypeVO{

	1: i32 fileTypeID,
	2: string fileCode,
	3: string fileName
}


struct DefinitionVO{

	1: i32 definitionID,
	2: string defCode,
	3: string defName
}

// 播放信息格式
struct OpenPlayInfoVO{
	
	// 播放信息ID
	1: i32 playID,
	
	// 视频ID
	2: i32 videoID,
	
	//  视频描述
	3: i32 ftypeID,
	
	//播放信息Hash码 
	4: string hashID,
	
	// 视频名称
	5: string fileName,
	
	// 文件大小
	6: i64 fileSize,
	
	// 
	7: bool disable,
	
	//更新时间
	8: i32 updateTime,
	
	// 创建时间
	9: i32 createTime,
	
	10: i32 definitionID,
	
	//清晰度
	11: DefinitionVO definitionVO,
	
	//文件类型
	12: i32 vedioTypeID,
	
	13: FileTypeVO vedioTypeVO,
	
}
/*
	retCode:200, retMsg:OK, infoList:结果数据, 含义：响应正常
	retCode:400, retMsg:"null idlist", infoList:null, 含义：参数错误，idList为null
	retCode:404, retMsg:"not found", infoList:null, 含义：通过mediaid查询未找到结果
	retCode:413, retMsg:"too many ids", infoList:null, 含义：参数错误，idList的元素个数超过限制，默认值1000（可配置）
	retCode:500, retMsg:"internal error", infoList: null, 含义：播放信息服务内部错误
*/
struct PlayInfoVOResult {
	1: i32 retCode,
	2: string retMsg,
	3: list<OpenPlayInfoVO> infoList
}

  
service OpenPlayInfoService {
	
	// 下面各接口中的clientType含义为客户端类型 
	
	//媒体播放信息服务接口
	
	//根据videoID、客户端类型查询播放信息
	PlayInfoVOResult getInfoByVideoID(1: i32 videoID ),
	
	//根据videoID列表、客户端类型查询播放信息
	PlayInfoVOResult getInfoByVideoIDList(1: list<i32> videoIDs ),
	
	//根据hashID、客户端类型查询播放信息
	PlayInfoVOResult getInfoByHashID(1: string hashID ), 
	
	//根据playID列表、客户端类型查询播放信息
	PlayInfoVOResult getInfoByPlayIDList(1: list<i32> playIDs ),
	
	//根据hashID列表、客户端类型查询播放信息
	PlayInfoVOResult getInfoByHashIDList(1: list<string> hashIDs ),	
	
	//根据videoID列表、hashID列表、客户端类型查询播放信息
	PlayInfoVOResult getInfoByVideoANDHashIDList(1: list<i32> videoDs,2: list<string> hashIDs ),	
	 
}
