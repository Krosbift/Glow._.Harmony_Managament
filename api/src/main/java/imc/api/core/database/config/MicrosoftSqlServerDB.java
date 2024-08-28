package imc.api.core.database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * MicrosoftSqlServerDB class
 * This class is used to create a DataSource and JdbcTemplate beans for Microsoft SQL Server
 */
@Configuration
public class MicrosoftSqlServerDB {

  /**
   * Create a DataSource bean
   * @return DataSource
   */
  @Bean
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    dataSource.setUrl("jdbc:sqlserver://javaims-server.database.windows.net:1433;database=cluster_javaIMS");
    dataSource.setUsername("CloudSAee535d6b");
    dataSource.setPassword("SAee535d6b");
    return dataSource;
  }

  /**
   * Create a JdbcTemplate bean
   * @param dataSource DataSource
   * @return JdbcTemplate
   */
  @Bean
  JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
