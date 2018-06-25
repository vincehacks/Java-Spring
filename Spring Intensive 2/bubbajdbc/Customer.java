/* Created by Vince Chang
 * This class is a business object that will interact with all parts of
 * the achitecture. This class will also show me the layout of how the
 * CUSTOMERS table looks like.
 */

package com.example.bubba;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Annotating the domain objects
@Entity
@Table(name="CUSTOMERS")
public class Customer {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  @Column(name="CUSTOMER_NAME")
  private String customerName;
  @Column(name="EMAIL")
  private String email;

  // Default Constructor (needed to avoid error)
  public Customer() {};
  public Customer(String customerName, String email) {
    super();
    this.customerName = customerName;
    this.email = email;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getCustomerName() {
    return customerName;
  }
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /* hashCode() & equals() determine the difference between objects of the same
   * name. Two purchases that have the same id need to be referred to as the
   * same object!
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
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
    Customer other = (Customer) obj;
    if (customerName == null) {
      if (other.customerName != null)
        return false;
    } else if (!customerName.equals(other.customerName))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (id != other.id)
      return false;
    return true;
  }
}