package com.keyholesoftware.demo.archunit.persistence;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({  "classpath:application.properties" })
@PropertySource({  "classpath:application-${spring.profiles.active}.properties"})
@EnableTransactionManagement
public class HibernateConf {
  
  @Autowired
  DataSource dataSource;
  
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
  
  @Bean
  public HibernateJpaVendorAdapter vendorAdapter() {
  HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
  vendorAdapter.setGenerateDdl(generateDDL.booleanValue());
  vendorAdapter.setShowSql(showSQL.booleanValue());
  vendorAdapter.setDatabasePlatform(dialect);
  vendorAdapter.setDatabase(Database.H2);
  return vendorAdapter;
  }
  
  protected void setUp() throws Exception {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "com.keyholesoftware.demo.archunit.persistence" );
}
   
  @Bean
  @Autowired
  public EntityManagerFactory entityManagerFactory()  
  {
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setDataSource(dataSource);
      factory.setJpaVendorAdapter(vendorAdapter());
      factory.setPackagesToScan("com.keyholesoftware.demo.archunit.domain");
      factory.setDataSource(dataSource);
      factory.setJpaProperties(hibernateProperties());
      factory.afterPropertiesSet();
    
      return factory.getObject();
  }
  
  @Bean("sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.keyholesoftware.demo.archunit.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory)  {
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
}
