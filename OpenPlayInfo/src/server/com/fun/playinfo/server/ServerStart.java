package com.fun.playinfo.server;

import java.sql.SQLException;

import com.fun.playinfo.utils.LogHelper;

public class ServerStart {

	private ThriftServer thriftServer;
	private final LogHelper log = new LogHelper("PlayInfoServerStart");

	public void work() throws SQLException, ClassNotFoundException {
		// 启动类是阻塞的，因此只会启动一次，如果启动失败，会再次启动
		while (true) {
			log.warn("try to init new instance of ThriftServer...");
			try {
				this.thriftServer = new ThriftServer();
				this.thriftServer.startService();
			} catch (Exception e) {
				log.error("failed to start server, try to restart...");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					log.error(e1.getMessage());
				}
			} finally {
				if (this.thriftServer != null) {
					log.warn("closing previous server...");
					thriftServer.close();
				}
			}
		}
	}

	public static void main(String[] args) {
		LogHelper log = new LogHelper("PlayInfoMain");
		try {
			ServerStart service = new ServerStart();
			service.work();
		} catch (SQLException e) {
			log.error("SQL error: ", e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.error("SQL error: ", e.getMessage());
			e.printStackTrace();
		}
	}
}
