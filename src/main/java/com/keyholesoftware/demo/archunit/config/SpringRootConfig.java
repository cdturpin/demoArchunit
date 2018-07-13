package com.keyholesoftware.demo.archunit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.keyholesoftware.demo.archunit"})
@Configuration
@EnableTransactionManagement
public class SpringRootConfig {
	
	@Autowired
	DataSource dataSource;

	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

}
