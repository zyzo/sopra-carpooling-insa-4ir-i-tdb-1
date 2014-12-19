package com.soprideshare.dao;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

	private static final String DB_CREDENTIALS_FILE = "dbCredentials.properties";
	private BoneCP connectionPool;
	
	private DAOFactory(BoneCP connectionPool) {
		this.connectionPool = connectionPool;
	}
	
	private static DAOFactory instance;
	public static DAOFactory getInstance() {
		if (instance == null)
			instance = initializeInstance();
		return instance;
	}
	
	private static DAOFactory initializeInstance() {
		Properties properties = new Properties();
		InputStream dbCredentialsFile = DAOFactory.class
				.getClassLoader()
				.getResourceAsStream(DB_CREDENTIALS_FILE);
		try {
			properties.load(dbCredentialsFile);
			String url = properties.getProperty("url");
			String driver = properties.getProperty("driver");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driver);
			BoneCPConfig config = new BoneCPConfig();
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);
			BoneCP connectionPool = new BoneCP(config);
			return new DAOFactory(connectionPool);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing database connection", e);
		}
	}
	
	Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}
	

}
