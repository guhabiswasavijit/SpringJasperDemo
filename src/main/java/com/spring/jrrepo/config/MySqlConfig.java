package com.spring.jrrepo.config;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MySqlConfig {
	private static final Logger LOG = LoggerFactory.getLogger(MySqlConfig.class);
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	
	
	@Bean(name = "mySqlConn")
	public Connection buildMySqlConnection(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		LOG.debug("Created DataSource:{}",ds.getUrl());
		try {
			Connection conn = ds.getConnection();
			conn.setAutoCommit(false);
			return conn;
		}catch(SQLException sqle) {
			LOG.error("Error while obtaining exception:{}",sqle.getMessage());
		}		
		return null;
	}
}
