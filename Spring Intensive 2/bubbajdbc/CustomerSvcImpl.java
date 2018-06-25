// Created by Vince Chang
// This is the implementation for CustomerSvc.java interface

package com.example.bubba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This annotiation defines a service
@Service
public class CustomerSvcImpl implements CustomerSvc{

  // This annotation goes to IPurchaseDAO.java and intiantiates an ICustomerDAO
  // object. Equivalent to private ICustomerDAO dao = new ICustomerDAO();
  @Autowired
  private ICustomerDAO dao;

  @Autowired
  private CustomerRepo repo;
  
  @Override
  public void saveCustomer(Customer c) {
    repo.save(c);
  }

  @Override
  public Customer findCustomerById(int id) {
    return dao.getCustomer(id);
  }
}