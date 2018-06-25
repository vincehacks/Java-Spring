// Created by Vince Chang
// This is the interface for CustomerSvcImpl.java

package com.example.bubba;

public interface CustomerSvc {
  void saveCustomer(Customer c);
  Customer findCustomerById(int id);
}