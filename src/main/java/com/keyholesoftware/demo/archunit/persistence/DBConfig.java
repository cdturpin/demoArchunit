package com.keyholesoftware.demo.archunit.persistence;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
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

  private static final String[] JPA_PACKAGES = new String[] { "com.keyholesoftware.demo.archunit.domain" };

  @Value("${spring.jpa.properties.jdbc.driverClassName}")
  String driverClassName;
  @Value("${spring.jpa.properties.jdbc.url}")
  String url;
  @Value("${spring.jpa.properties.jdbc.username}")
  String username;
  @Value("${spring.jpa.properties.jdbc.password}")
  String password;
  @Value("${spring.jpa.properties.hibernate.dialect}")
  String dialect;
  @Value("${spring.jpa.hibernate.ddl-auto}")
  String ddlAuto;
  @Value("${spring.jpa.hibernate.naming.strategy}")
  String strategy;
  @Value("${spring.jpa.generate-ddl}")
  Boolean generateDDL;
  @Value("${spring.jpa.show-sql}")
  Boolean showSQL;
  @Value("${spring.jpa.properties.hibernate.generate_statistics}")
  Boolean showStatistics;

  @Resource
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
  public HibernateJpaVendorAdapter hibernateVendorAdapter() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(generateDDL.booleanValue());
    vendorAdapter.setShowSql(showSQL.booleanValue());
    vendorAdapter.setDatabasePlatform(dialect);
    vendorAdapter.setDatabase(Database.H2);
    return vendorAdapter;
  }

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(dataSource());
    factory.setJpaVendorAdapter(hibernateVendorAdapter());
    factory.setPackagesToScan(JPA_PACKAGES);
    factory.setJpaProperties(hibernateProperties());
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  @Bean("sessionFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(JPA_PACKAGES);
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateExceptionTranslator hibernateExceptionTranslator() {
    return new HibernateExceptionTranslator();
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);
    return txManager;
  }

  private final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("spring.jpa.properties.hibernate.dialect", dialect);
    hibernateProperties.setProperty("spring.jpa.hibernate.ddl-auto", ddlAuto);
    hibernateProperties.setProperty("spring.jpa.hibernate.naming.strategy", strategy);
    hibernateProperties.setProperty("hibernate.generate_statistics", showStatistics.toString());
    return hibernateProperties;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws Exception {
//    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//    entityManagerFactoryBean.setDataSource(dataSource());
//    entityManagerFactoryBean.setPackagesToScan(JPA_PACKAGES);
//    entityManagerFactoryBean.setJpaVendorAdapter(hibernateVendorAdapter());
//    entityManagerFactoryBean.setJpaProperties(hibernateProperties());
//    return entityManagerFactoryBean;
//  }

  @Bean
  public PlatformTransactionManager transactionManager() throws Exception {
    EntityManagerFactory factory = entityManagerFactory();
    return new JpaTransactionManager(factory);
  }

}
