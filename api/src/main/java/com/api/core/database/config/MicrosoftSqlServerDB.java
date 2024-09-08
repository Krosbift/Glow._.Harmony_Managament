package com.api.core.database.config;

import com.api.core.config.env.EnvConfig;
import com.api.core.config.env.enums.EnvKeys;

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

  private final EnvConfig envConfig;

  public MicrosoftSqlServerDB() {
    this.envConfig = new EnvConfig();
  }

  /**
   * Returns the configured DataSource for connecting to the Microsoft SQL Server
   * database.
   *
   * @return the configured DataSource object
   */
  @Bean
  DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(envConfig.get(EnvKeys.DB_URL));
    dataSource.setUsername(envConfig.get(EnvKeys.DB_USERNAME));
    dataSource.setPassword(envConfig.get(EnvKeys.DB_PASSWORD));
    dataSource.setDriverClassName(envConfig.get(EnvKeys.DB_DRIVER_CLASS_NAME));
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