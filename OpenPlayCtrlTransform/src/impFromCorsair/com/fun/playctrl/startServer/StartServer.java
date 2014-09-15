package com.fun.playctrl.startServer;

import com.fun.playctrl.service.TransferDataService;

/**
 * ClassName:StartServer <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-9-9 下午5:41:26 <br/>
 * 
 * @author zhenglq
 * @version
 * @since JDK 1.7
 * @see
 */
public class StartServer {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Runtime currRuntime = Runtime.getRuntime();
		int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		System.out.println(nFreeMemory + "M/" + nTotalMemory + "M(free/total)");
		TransferDataService service = new TransferDataService();
		service.transfer();
		currRuntime = Runtime.getRuntime();
		nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		System.out.println(nFreeMemory + "M/" + nTotalMemory + "M(free/total)");
		long end = System.currentTimeMillis();

		System.out.println("transfer data toatl cost :" + (end - begin) / 1000
				/ 60 + "minitue");
	}
}
