package com.fun.playinfo.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.funshion.configcenter.ConfigCenter;
import com.funshion.configcenter.IConfigCenter;

/**
 * 
 * 配置中心，方法计数器，发送心跳做健康检查 <br/>
 * date: 2014-9-4 下午3:11:35 <br/>
 * 
 * @version
 * @author zhenglq
 * @since JDK 1.7
 */
public class CCHandler extends Thread implements IConfigCenter {
	private final Date startDate;
	private final String[] counterNames;
	private static HashMap<String, Counter> counters;

	public CCHandler(String[] names) {
		startDate = new Date();
		counters = new HashMap<>();

		counterNames = names;
		initCounters(names);
		start();
	}

	public void initCounters(String[] names) {
		for (int i = 0, len = names.length; i < len; i++) {
			String name = names[i];
			Counter c = new Counter(name);
			counters.put(name, c);
		}
	}

	@Override
	public void run() {
		int seconds = 60;
		while (true) {
			try {
				sleep(seconds * 1000);
				calcRqsIn1Min();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void calcRqsIn1Min() {
		for (Entry<String, Counter> entry : counters.entrySet()) {
			Counter c = entry.getValue();
			c.setOkInLastMin();
			c.setErrInLastMin();
		}
	}

	public static long addOk(String name) {
		Counter c = counters.get(name);
		return c.addOk();
	}

	public static long addErr(String name) {
		Counter c = counters.get(name);
		return c.addErr();
	}

	@Override
	public void configNotify(String remote, String json) {
		ConfigCenter.log.info("remote: " + remote + ", " + json);
	}

	@Override
	public String getSys(String arg0) {
		String ret = "{";
		ret += "\n\"sysinfo\": {";
		ret += getInfo();
		ret += "}, \n\"counters\": {";
		ret += getCounters();
		ret += "}\n";
		ret += "}";
		return ret;
	}

	private String getCounters() {
		long rpcOkAll = 0;
		long rpcOkAllLastMin = 0;
		long rpcOkAllCurMin = 0;

		long rpcErrAll = 0;
		long rpcErrAllLastMin = 0;
		long rpcErrAllCurMin = 0;

		String counterStats = "";
		for (int i = 0, len = counterNames.length; i < len; i++) {
			String name = counterNames[i];
			Counter c = counters.get(name);
			long ok = c.getOk();
			long okInLastMin = c.getOkInLastMin();
			long okInCurMin = c.getOkInCurMin();

			long err = c.getErr();
			long errInLastMin = c.getErrInLastMin();
			long errInCurMin = c.getErrInCurMin();

			String s = "\"" + c.getName() + "\": ";
			s += "{";
			s += "\t\"ok\": " + ok + ", \n";
			s += "\t\"okInLastMin\": " + okInLastMin + ", \n";
			s += "\t\"okInCurMin\": " + okInCurMin + ", \n";
			s += "\t\"err\": " + err + "\n";
			s += "}";

			if (counterStats.isEmpty()) {
				counterStats = s;
			} else {
				counterStats += ",\n" + s;
			}

			rpcOkAll += ok;
			rpcOkAllLastMin += okInLastMin;
			rpcOkAllCurMin += okInCurMin;

			rpcErrAll += err;
			rpcErrAllLastMin += errInLastMin;
			rpcErrAllCurMin += errInCurMin;
		}

		String all = "\"all\": ";
		all += "{";
		all += "\t\"ok\": " + rpcOkAll + ", \n";
		all += "\t\"okInLastMin\": " + rpcOkAllLastMin + ", \n";
		all += "\t\"okInCurMin\": " + rpcOkAllCurMin + ", \n";
		all += "\t\"err\": " + rpcErrAll + ", \n";
		all += "\t\"errInLastMin\": " + rpcErrAllLastMin + ", \n";
		all += "\t\"errInCurMin\": " + rpcErrAllCurMin + "\n";
		all += "}";

		return all + ", \n" + counterStats;
	}

	private String getInfo() {
		long runningTime = ((new Date()).getTime() - startDate.getTime()) / 1000;
		int d = (int) (runningTime / (24 * 3600));
		int remainingSeconds = (int) (runningTime % (24 * 3600));
		int h = remainingSeconds / 3600;
		int m = remainingSeconds % 3600 / 60;

		String sysInfo = "";
		sysInfo += "\t\"startdate\": ";
		sysInfo += "\"" + startDate.toString() + "\",\n";
		sysInfo += "\t\"currentdate\": ";
		sysInfo += "\"" + (new Date()).toString() + "\",\n";
		sysInfo += "\t\"running\": ";
		sysInfo += "\"" + d + " days " + h + " hours " + m + " minutes"
				+ "\",\n";
		sysInfo += "\t\"system:\": ";
		sysInfo += "\"" + System.getProperty("os.name") + "_"
				+ System.getProperty("os.version") + "\",\n";
		sysInfo += "\t\"arch\": ";
		sysInfo += "\"" + System.getProperty("os.arch") + "\",\n";
		sysInfo += "\t\"platform\": ";
		sysInfo += "\"" + "JAVA_" + System.getProperty("java.version")
				+ "\",\n";
		sysInfo += "\t\"total_mem\": ";
		sysInfo += "\"" + Runtime.getRuntime().totalMemory() / 1024 / 1024
				+ "MB\",\n";
		sysInfo += "\t\"free_mem\": ";
		sysInfo += "\"" + Runtime.getRuntime().freeMemory() / 1024 / 1024
				+ "MB\"\n";

		return sysInfo;
	}

}
