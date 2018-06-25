/* Created by Vince Chang
 * This class is a business object that will interact with all parts of
 * the achitecture. This class will also show me the layout of how the
 * PURCHASES table looks like.
 */

package com.example.bubba;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Annotating the domain objects
@Entity
@Table(name="PURCHASES")
public class Purchase {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column(name="PURCHASE_DATE")
  private Date purchaseDate;
  @Column(name="PRODUCT")
  private String product;

  // Default Constructor (needed to avoid error)
  public Purchase() {};
  public Purchase(int id, Date purchaseDate, String product) {
    super();
    this.id = id;
    this.purchaseDate = purchaseDate;
    this.product = product;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public Date getPurchaseDate() {
    return purchaseDate;
  }
  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }
  public String getProduct() {
    return product;
  }
  public void setProduct(String product) {
    this.product = product;
  }

  /* hashCode() & equals() determine the difference between objects of the same
   * name. Two purchases that have the same id need to be referred to as the
   * same object!
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Purchase other = (Purchase) obj;
    if (id != other.id)
      return false;
    return true;
  }
}