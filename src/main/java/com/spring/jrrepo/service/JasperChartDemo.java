package com.spring.jrrepo.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private java.sql.Connection mySqlConn;
	
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
	
	public void generateCrossTabChartDemo() {
		try 
		{
			log.debug("About to generate CrossTabChartDemo:");
			InputStream employeeReportStream = this.getClass().getResourceAsStream("/templates/DemoCrossTab.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);		
			Map<String, Object> parameters = new HashMap<>();			
			parameters.put("createdBy",System.getProperty("user.name"));			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, mySqlConn);
			JasperExportManager.exportReportToPdfFile(jasperPrint, jrRepoPath + "employeesCrossTabChart.pdf");

		} 
		catch (JRException e) 
		{
			e.printStackTrace();
			log.error("JRException : ", e.getMessage(), e.getCause());
		}
	}
	public void generate3DBarChartDemo() {
		try 
		{
			log.debug("About to generate 3DBarChart:");
			InputStream employeeReportStream = this.getClass().getResourceAsStream("/templates/Demo3DBarChart.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);		
			Map<String, Object> parameters = new HashMap<>();			
			parameters.put("ReportTitle","3D Bar Chart");			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, mySqlConn);
			JasperExportManager.exportReportToPdfFile(jasperPrint, jrRepoPath + "employees3DBarChart.pdf");

		} 
		catch (JRException e) 
		{
			e.printStackTrace();
			log.error("JRException : ", e.getMessage(), e.getCause());
		}
	}
	public void generate3DPieChartDemo() {
		try 
		{
			log.debug("About to generate 3DPieChart:");
			InputStream employeeReportStream = this.getClass().getResourceAsStream("/templates/Pie3DChartReport.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);		
			Map<String, Object> parameters = new HashMap<>();			
			parameters.put("ReportTitle","3D Pie Chart");
			parameters.put("MaxOrderID",10250);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, mySqlConn);
			JasperExportManager.exportReportToPdfFile(jasperPrint, jrRepoPath + "order3DPieChart.pdf");

		} 
		catch (JRException e) 
		{
			e.printStackTrace();
			log.error("JRException : ", e.getMessage(), e.getCause());
		}
	}

}
