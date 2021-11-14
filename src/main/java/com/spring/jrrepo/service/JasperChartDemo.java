package com.spring.jrrepo.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
@Slf4j
@Component("JasperChartDemo")
public class JasperChartDemo {
	@Value("${jasper.report.path}")
	private String jrRepoPath;
	
	public void generateChartDemo() {
		try 
		{
			InputStream employeeReportStream = this.getClass().getResourceAsStream("/templates/ChartCustomizersReport.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
			JREmptyDataSource dataSource = new JREmptyDataSource();			
			Map<String, Object> parameters = new HashMap<>();			
			parameters.put("createdBy",System.getProperty("user.name"));			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, jrRepoPath + "employeesChart.pdf");

		} 
		catch (JRException e) 
		{
			log.error("JRException : ", e.getMessage(), e.getCause());
		}
	}

}
