package com.keyholesoftware.demo.archunit.persistence;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@PropertySource({ "classpath:application-${spring.profiles.active}.properties" })
@ComponentScan("com.keyholesoftware.demo.archunit")
@EnableJpaRepositories
@EnableSpringConfigured
public class DBConfig {

  private final Logger log = LoggerFactory.getLogger(DBConfig.class);

  private static final String[] JPA_PACKAGES =
      new String[] { "com.keyholesoftware.demo.archunit.domain" };

  @Value("${spring.jpa.properties.jdbc.driverClassName}")
  String driverClassName;
  @Value("${spring.jpa.properties.jdbc.url}")
  String url;
  @Value("${spring.jpa.properties.jdbc.username}")
  String username;
  @Value("${spring.jpa.properties.jdbc.password}")
  String password;
 
  @Autowired
  HibernateJpaVendorAdapter vendorAdapter;

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
   
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    //Add package to scan for entities.
    factory.setPackagesToScan("com.keyholesoftware.demo.archunit");
    factory.setDataSource(dataSource());
    return factory;
  }

  @Bean
  public PlatformTransactionManager transactionManager(
      EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);

    return transactionManager;
  }

}
