/* Created by Vince Chang
 * Interface for the DAO (Data Access Object)
 * This is the interface that speaks to the database
 */

package com.example.bubba;
import java.util.Collection;

public interface ICustomerDAO {
  Customer getCustomer(int id);
}