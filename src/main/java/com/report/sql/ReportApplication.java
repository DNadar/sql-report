package com.report.sql;


import com.report.sql.configuration.SqlConfiguration;
import com.report.sql.email.SendEmail;
import com.report.sql.filegenerator.ExcelFileGenerator;
import com.report.sql.repository.JDBCSQLConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:sql-query.properties")
})
@EnableConfigurationProperties(SqlConfiguration.class)
public class ReportApplication /* implements CommandLineRunner */{


	private static final Logger log = LoggerFactory.getLogger(ReportApplication.class);

	@Autowired
	private JDBCSQLConnector connector;

	@Autowired
	private ExcelFileGenerator generator;

	@Autowired
	private SendEmail email;

	public static void main(String[] args) {

		log.info("Starting ReportApplication....");
		SpringApplication.run(ReportApplication.class, args);
		log.info("ReportApplication successfully Started!");
	}
}
