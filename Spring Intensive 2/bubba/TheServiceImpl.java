// Created by Vince Chang
// This is the implementation of TheService that just prints out a message

package com.example.bubba;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// This annotiation defines a service
@Service
public class TheServiceImpl implements TheService {

  // This annotation will result from application.properties
  @Value("${message}")
  private String msg;

  // Even though @Override isn't necessary, it is helpful to catch errors and
  // let compiler know that I am overriding a method from the interface!
  @Override
  public String doTheService() {
    return msg;
  }
}