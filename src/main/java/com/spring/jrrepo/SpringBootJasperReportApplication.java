package com.spring.jrrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jrrepo.service.JasperChartDemo;

@SpringBootApplication
public class SpringBootJasperReportApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootJasperReportApplication.class, args);
		JasperChartDemo demo = (JasperChartDemo)ctx.getBean("JasperChartDemo");
		demo.generateChartDemo();
	}

}
