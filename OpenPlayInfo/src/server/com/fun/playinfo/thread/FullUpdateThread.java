package com.fun.playinfo.thread;

import com.fun.playinfo.service.PlayInfoHandler;
import com.fun.playinfo.utils.CCHandler;
import com.fun.playinfo.utils.LogHelper;

/**
 * 全数据更新服务<br/>
 * Date: 2014-9-13 下午2:47:35 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class FullUpdateThread extends Thread {
	private final LogHelper log = new LogHelper("FullUpdateThread");
	private final PlayInfoHandler handler;
	private final int updateInterval;
	// 全站更新偏差，由于全站数据更新需要耗费一定时间，因此需要计算偏差，以保证每间隔updateInterval分钟执行一次全站更新
	private int offsetTime = 0;

	public FullUpdateThread(PlayInfoHandler handler, int updateInterval) {
		this.handler = handler;
		// 全站刷新换算为秒，
		this.updateInterval = updateInterval * 60 * 1000;
	}

	@Override
	public void run() {
		while (true) {
			boolean isFullUpdate = false;
			try {
				// 间隔updateInterval分钟执行一次全站更新
				if (updateInterval > offsetTime) {
					sleep(updateInterval - offsetTime);
				}
				long beginTime = System.currentTimeMillis();
				handler.fullUpdateMemory();
				long endTime = System.currentTimeMillis();
				// 全站更新耗时
				offsetTime = (int) ((endTime - beginTime) / 1000);
				log.info("the fully update data used  %d second", offsetTime);
			} catch (Exception e) {
				String c = isFullUpdate ? "fullUpdate" : "update";
				CCHandler.addErr(c);
				log.error(e, "FullUpdateThread thread running error: %s",
						e.getMessage());
			}
		}
	}
}
