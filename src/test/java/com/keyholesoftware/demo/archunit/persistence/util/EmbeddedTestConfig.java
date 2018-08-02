package com.keyholesoftware.demo.archunit.persistence.util;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories( basePackages = { "com.keyholesoftware.demo.archunit" })
@EnableTransactionManagement
public class EmbeddedTestConfig {
    
    private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:%s/target/db/northwind;AUTO_SERVER=TRUE";
    
    @Value("classpath:schema-northwind.sql")
    private Resource H2_SCHEMA_SCRIPT;
    
    @Value("classpath:data-northwind.sql")
    private Resource H2_DATA_SCRIPT;
    
    @Value("classpath:drop-data.sql")
    private Resource H2_CLEANER_SCRIPT;

    @Bean
    @Profile("dev")
    @Primary
    @ConfigurationProperties("app.datasource.embedded")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:northwind;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        return dataSource;
    }
    
    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.embedded")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

//    @Bean
//    @Primary
//    @ConfigurationProperties("app.datasource.first")
//    public DataSource firstDataSource() {
//        return firstDataSourceProperties().initializeDataSourceBuilder().build();
//    }

//    @Bean
//    @ConfigurationProperties("app.datasource.second")
//    public BasicDataSource secondDataSource() {
//        return DataSourceBuilder.create().type(BasicDataSource.class).build();
//    }
    
    @Bean
    public DataSource dataSource(Environment env) throws Exception {
            return createH2DataSource();
    }

    @Autowired
    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {

        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        initializer.setDatabaseCleaner(databaseCleaner());
        return initializer;
    }


    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript( H2_SCHEMA_SCRIPT);
        populator.addScript(H2_DATA_SCRIPT);
        return populator;
    }

    private DatabasePopulator databaseCleaner() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(H2_CLEANER_SCRIPT);
        return populator;
    }

    private DataSource createH2DataSource() {
        String jdbcUrl = String.format(H2_JDBC_URL_TEMPLATE, System.getProperty("user.dir"));
        JdbcDataSource ds = new JdbcDataSource();       
        ds.setURL(jdbcUrl);
        ds.setUser("sa");
        ds.setPassword("sa");

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env) throws Exception {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);     

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setPersistenceUnitName("northwind");
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.keyholesoftware.demo.archunit");
        factory.setDataSource(dataSource(env));     

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    // configure entityManagerFactory
    // configure transactionManager
    // configure additional Hibernate properties
}