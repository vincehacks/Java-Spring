/* Created by Vince Chang
 * Interface for the DAO (Data Access Object)
 * This is the interface that speaks to the database
 */

package com.example.bubba;
import java.util.Collection;

public interface IPurchaseDAO {
  void savePurchase(Purchase P);
  Collection<Purchase> getAllPurchases();
  Purchase getPurchase(int id);
}