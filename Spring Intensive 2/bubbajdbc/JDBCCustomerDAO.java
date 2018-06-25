/* Created by Vince Chang
 * This is the implementation of the ICustomerDAO.java interface
 * This class will speak to the database
 */

package com.example.bubba;
import java.util.Collection;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// This annotiation defines a Repository
@Repository
public class JDBCCustomerDAO implements ICustomerDAO {

  // This template instianates a JdbcTemplate object & allows access to the db
  @Autowired
  private JdbcTemplate jdbcTemplate;

  // Look at the value at application.properties
  @Value("${app.name}")
  private String appName;

  /* This tells me when the DB has been initialized. It also allows you to do
   * something after the bean has been created and all dependencies have been
   * injected
   */
  @PostConstruct
  public void init() {
    System.out.println("APP NAME-> " + appName);
  }

  // This will return back one Customer Object (.json)
  @Override
  public Customer getCustomer(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM CUSTOMERS WHERE ID="+id,
        new BeanPropertyRowMapper<Customer>(Customer.class));
  }
}