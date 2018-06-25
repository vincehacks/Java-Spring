// Created by Vince Chang
// This is the interface for PurchaseSvcImpl.java

package com.example.bubba;
import java.util.Collection;

public interface PurchaseSvc {
  void savePurchase(Purchase p);
  Iterable<Purchase> findAllPurchases();
  Purchase findPurchaseById(int id);
}