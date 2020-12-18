package com.report.sql.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ConfigurationProperties
@PropertySource("classpath:sql-query.properties")
public class SqlConfiguration {

    @Autowired
    private Environment env;

    public String getProperty(String sParam) {
       return env.getProperty(sParam);
    }

}
