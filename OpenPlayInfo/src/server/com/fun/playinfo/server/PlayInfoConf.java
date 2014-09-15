package com.fun.playinfo.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fun.playinfo.utils.ConfUtils;
import com.fun.playinfo.utils.ConfigReader;

public class PlayInfoConf {
	public File confFile;
	public int workerNum;
	public int rpcPort;
	public int httpPort;
	public int readTimeout;
	public String ccHost;
	public String localName;

	// 扫描库表的间隔时间
	public int fullUpdateInterval;
	public int updateInterval;
	// 触发全量更新的最小的变动mediaid数
	public int fullUpdateThrottle;
	public List<String> fullUpdateTimes;
	// 扫描库表时modifydate字段的冗余时间
	public int mofidyDateRedundancy;

	// thrift接口允许的参数列表最大长度
	public int idListMaxLen;
	public String cpyrtIDs;
	public String torrentURL;
	public List<String> clients;

	public List<String> sqlParams;

	public PlayInfoConf(String confFilePath) throws IOException,
			InterruptedException {
		confFile = ConfUtils.getConfFile(confFilePath);

		ConfigReader cr = new ConfigReader(confFile, "system");
		workerNum = cr.getInt("worker_num");
		rpcPort = cr.getInt("rpc_port");
		httpPort = cr.getInt("http_port");
		readTimeout = cr.getInt("read_timeout", 5000);
		ccHost = cr.getValue("config_center");
		localName = cr.getValue("local_name");

		updateInterval = cr.getInt("update_interval", 20);
		fullUpdateInterval = cr.getInt("full_update_interval", 60);
		fullUpdateThrottle = cr.getInt("full_update_throttle", 2000);

		String fullUpdateTimesStr = cr.getValue("full_update_time", "04:10");
		fullUpdateTimes = timeValParser(fullUpdateTimesStr);

		mofidyDateRedundancy = cr.getInt("mofidydate_shift", 1);

		cr = new ConfigReader(ConfUtils.getConfFile(confFilePath), "service");
		idListMaxLen = cr.getInt("list_max_len", 500);
		cpyrtIDs = cr.getValue("copyright_ids");
		torrentURL = cr.getValue("torrent_url", "http://www.btstream.org");
		String clientStr = cr.getValue("clients");
		clients = strValParser(clientStr);

		cr = new ConfigReader(ConfUtils.getConfFile(confFilePath), "mysql");
		String sqlParamsStr = cr.getValue("params");
		sqlParams = strValParser(sqlParamsStr);

		cr = null;
	}

	private List<String> strValParser(String val) {
		val = formatter(val);
		return Arrays.asList(val.split(","));
	}

	private List<String> timeValParser(String val) {
		List<String> times = new ArrayList<>();
		if (val != null) {
			val = formatter(val);
			String[] inputTimes = val.split(",");
			for (int i = 0, len = inputTimes.length; i < len; i++) {
				String[] hm = inputTimes[i].split(":");
				try {
					int updateH = Integer.parseInt(hm[0]);
					int updateM = Integer.parseInt(hm[1]);

					if (0 <= updateH && updateH <= 24 && 0 <= updateM
							&& updateM <= 60) {
						times.add(inputTimes[i]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return times;
	}

	private String formatter(String src) {
		src = src.trim();
		src = src.replace("\r", "");
		src = src.replace("\n", "");
		src = src.replace(" ", "");

		if (src.endsWith(",")) {
			src = src.substring(0, src.length() - 1);
		}

		return src;
	}
}
