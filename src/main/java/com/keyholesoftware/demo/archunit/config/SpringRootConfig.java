package com.keyholesoftware.demo.archunit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.keyholesoftware.demo.archunit.persistence.repository"),
      @ComponentScan("com.keyholesoftware.demo.archunit.service") })
public class SpringRootConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    
    @Bean
    public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
       LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
       factoryBean.setPersistenceUnitName("LOCAL_PERSISTENCE");
       return factoryBean;
    }

    @Bean
    public JpaTransactionManager geJpaTransactionManager() {
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
       return transactionManager;
    }
}
