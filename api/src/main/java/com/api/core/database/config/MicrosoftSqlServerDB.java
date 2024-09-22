package com.api.core.database.config;
import com.api.core.config.env.EnvConfig;
import com.api.core.config.env.enums.EnvKeys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
/**
 * Configuration class for setting up a Microsoft SQL Server database connection.
 * This class provides beans for DataSource and JdbcTemplate.
 * 
 * <p>It uses {@link EnvConfig} to retrieve the necessary environment variables
 * for configuring the database connection.</p>
 * 
 * <p>Beans provided:</p>
 * <ul>
 *   <li>{@link DataSource} - Configured with the necessary connection properties.</li>
 *   <li>{@link JdbcTemplate} - Configured with the provided {@link DataSource}.</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Autowired
 * private JdbcTemplate jdbcTemplate;
 * 
 * public void someMethod() {
 *     String sql = "SELECT * FROM some_table";
 *     List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
 *     // process results
 * }
 * }
 * </pre>
 * 
 * @see EnvConfig
 * @see DataSource
 * @see JdbcTemplate
 */
@Configuration
public class MicrosoftSqlServerDB {
  private final EnvConfig envConfig;
  public MicrosoftSqlServerDB() {
    this.envConfig = new EnvConfig();
  }
  /**
   * Configures and returns a DataSource bean for connecting to a Microsoft SQL Server database.
   * 
   * @return DataSource configured with the necessary connection properties.
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
   * Creates a {@link JdbcTemplate} bean configured with the provided {@link DataSource}.
   *
   * @param dataSource the {@link DataSource} to be used by the {@link JdbcTemplate}
   * @return a configured {@link JdbcTemplate} instance
   */
  @Bean
  JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}