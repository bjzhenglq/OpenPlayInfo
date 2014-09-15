package com.fun.playinfo.thread;

import com.fun.playinfo.service.PlayInfoHandler;
import com.fun.playinfo.utils.CCHandler;
import com.fun.playinfo.utils.LogHelper;

/**
 * ClassName:UpdateThread <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-13 下午3:17:30 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class UpdateThread extends Thread {
	private final LogHelper log = new LogHelper("UpdateThread");
	private final PlayInfoHandler handler;
	private final int updateInterval;

	public UpdateThread(PlayInfoHandler handler, int updateInterval) {
		this.handler = handler;
		// 全站刷新换算为秒，
		this.updateInterval = updateInterval * 1000;

	}

	@Override
	public void run() {
		while (true) {
			boolean isFullUpdate = false;
			try {
				sleep(updateInterval);
				// 检查是否全量更新时间，必须在sleep之后，否则会判断出错
				handler.updateMemory();
			} catch (Exception e) {
				String c = isFullUpdate ? "fullUpdate" : "update";
				CCHandler.addErr(c);
				log.error(e, "thread running error: %s", e.getMessage());
			}
		}
	}
}
