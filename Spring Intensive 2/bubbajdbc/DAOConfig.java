/* Created by Vince Chang
 * This class is where jdbcTemplate will come from and it will also interact
 * with the Data Base
 */

package com.example.bubba;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

// This annotation defines a configuration
@Configuration
public class DAOConfig {

  @Bean
  JdbcTemplate jdbcTemplate(DataSource ds) {
    return new JdbcTemplate(ds);
  }
}
