namespace java com.fun.playinfo.thrift
// 问题1：需要增加判断video类型的字段（直播？点播？）

include "OpenPlayInfo.thrift"

struct PlayInfo {
	1: i32 playinfoId,
	2: string hashId,
	3: bool success,
	4: string msg
}

struct PlayInfoOPResult {
	1: i32 retCode,
	2: string retMsg,
	3: list<PlayInfo> result
}

struct FileType  {
	1: i32 playinfoId, 
	2: bool success,
	3: string msg
}

// 存储批量操作结果
struct FileTypeOPResult {

	1: i32 retCode,
	2: string retMsg,
	3: list<FileType> result
}

struct Definition {
	1: i32 playinfoId, 
	2: bool success,
	3: string msg
}

// 存储批量操作结果
struct DefinitionOPResult {

	1: i32 retCode,
	2: string retMsg,
	3: list<Definition> result
}


service OpenPlayInfoOpService {

	PlayInfoOPResult addPlayInfos(1: list<OpenPlayInfo.OpenPlayInfoVO> params),
	PlayInfoOPResult updatePlayInfos(1: list<OpenPlayInfo.OpenPlayInfoVO> params),
	
	FileTypeOPResult addFileTypes(1: list<OpenPlayInfo.FileTypeVO> params),
	FileTypeOPResult updateFileTypes(1: list<OpenPlayInfo.FileTypeVO> params),
	
	DefinitionOPResult addDefinitions(1: list<OpenPlayInfo.DefinitionVO> params),
	DefinitionOPResult updateDefinitions(1: list<OpenPlayInfo.DefinitionVO> params),
}