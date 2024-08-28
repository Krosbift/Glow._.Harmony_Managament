package imc.api.core.database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Configuration class for connecting to the Microsoft SQL Server database.
 */
@Configuration
public class MicrosoftSqlServerDB {


  /**
   * Returns the configured DataSource for connecting to the Microsoft SQL Server database.
   *
   * @return the configured DataSource object
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
   * Creates a new JdbcTemplate instance with the given DataSource.
   *
   * @param dataSource the DataSource to be used by the JdbcTemplate
   * @return a new JdbcTemplate instance
   */
  @Bean
  JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
