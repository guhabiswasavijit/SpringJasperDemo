package com.spring.jrrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jrrepo.service.JasperChartDemo;
import com.spring.jrrepo.util.JasperDemoDataUploader;

@SpringBootApplication
public class SpringBootJasperReportApplication {

	public static void main(String[] args){
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootJasperReportApplication.class, args);
		JasperChartDemo demo = (JasperChartDemo)ctx.getBean("JasperChartDemo");
		demo.generateCrossTabChartDemo();
		//demo.generateChartDemo();
		//demo.generateCrossTabChartDemo();
		//demo.generate3DBarChartDemo();
		//demo.generate3DPieChartDemo();
		/*
		 * JasperDemoDataUploader dataUploader =
		 * (JasperDemoDataUploader)ctx.getBean("JasperDemoDataUploader"); try{
		 * dataUploader.createDemoData(); }catch(Exception ex) { ex.printStackTrace(); }
		 */	
	}

}
