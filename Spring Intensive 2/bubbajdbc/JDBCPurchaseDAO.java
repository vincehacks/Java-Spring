/* Created by Vince Chang
 * This is the implementation of the IPurchaseDAO.java interface
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
public class JDBCPurchaseDAO implements IPurchaseDAO {

  // This template intianates a JdbcTemplate object & allows access to the db
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

  @Override
  public void savePurchase(Purchase P) {
    jdbcTemplate.update("INSERT INTO PURCHASE (PRODUCT,PURCHASEDATE)",
        P.getProduct(),P.getPurchaseDate());
  }

  // This is the only query I will need!
  @Override
  public Collection<Purchase> getAllPurchases() {
    return jdbcTemplate.query("SELECT * FROM purchases",
        new BeanPropertyRowMapper<Purchase>(Purchase.class));
  }

  // This will return back one Purchase Object (.json)
  @Override
  public Purchase getPurchase(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM purchases WHERE ID="+id,
        new BeanPropertyRowMapper<Purchase>(Purchase.class));
  }
}