package com.spring.jrrepo.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("JasperDemoDataUploader")
public class JasperDemoDataUploader {
	@Autowired
	private Connection conn;
	
	public boolean createDemoData() throws SQLException, Exception{
		Path path = Paths.get("C:\\SampleData\\JasperReportSampleData.sql");
		Statement stmt = conn.createStatement();
		Stream<String> lines = Files.lines(path);
		lines.forEach(sqlString -> {
			try {
				stmt.addBatch(sqlString);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		stmt.executeBatch();
		conn.commit();
		stmt.close();
		lines.close();
		conn.close();
		return true;
	}
}
