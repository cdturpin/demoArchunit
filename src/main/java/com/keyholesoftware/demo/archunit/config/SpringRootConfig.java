package com.keyholesoftware.demo.archunit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaRepositories
@ComponentScans(value = { @ComponentScan("com.keyholesoftware.demo.archunit.persistence.repository"),
      @ComponentScan("com.keyholesoftware.demo.archunit.service") })
public class SpringRootConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
