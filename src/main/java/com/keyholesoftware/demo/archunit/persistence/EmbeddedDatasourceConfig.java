package com.keyholesoftware.demo.archunit.persistence;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile("dev")
@PropertySource(name="dev", value= {
    "classpath:application.properties", 
    "classpath:application-dev.properties"})
public class EmbeddedDatasourceConfig {
  
  
  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  private Environment env = ctx.getEnvironment();

    	@Bean
    	public DataSource dataSource() {
    	  // @formatter:off
    		return new EmbeddedDatabaseBuilder()
    		          .generateUniqueName(true)
    		          .setType(EmbeddedDatabaseType.H2)
    		          .addScript("classpath:/schema-northwind-h2.sql")
    		          .addScript("classpath:/data-northwind-h2.sql")
    		          .build();
    		      // @formatter:on
    		    }
    				//.setName("northwind")

    /**
    * Open the TCP port for the H2 database, so it is available remotely.
    *
    * @return the H2 database TCP server
    * @throws SQLException if the server failed to start
    */
        @Bean(initMethod = "start", destroyMethod = "stop")
        @Profile("dev")
        public Server h2TCPServer() throws SQLException {
            return Server.createTcpServer("-tcp","-tcpAllowOthers");
        }
}
