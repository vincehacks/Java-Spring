// Created by Vince Chang
// This is the implementation for the PurchaseSvc.java interface

package com.example.bubba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This annotiation defines a service
@Service
public class PurchaseSvcImpl implements PurchaseSvc {

  // This annotation goes to IPurchaseDAO.java and intiantiates an IPurchaseDAO
  // object. Equivalent to private IPurchaseDAO dao = new IPurchaseDAO();
  @Autowired
  private IPurchaseDAO dao;

  @Autowired
  private PurchaseRepo repo;

  @Override
  public void savePurchase(Purchase p) {
    repo.save(p);
  }

  @Override
  public Iterable<Purchase> findAllPurchases() {
    return repo.findAll();
  }

  @Override
  public Purchase findPurchaseById(int id) {
    return dao.getPurchase(id);
  }
}