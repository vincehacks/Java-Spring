// Created by Vince Chang

package com.example.bubba;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// This annotation defines a SpringBootApplication
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BubbajdbcApplication {

  public static void main(String[] args) {
    SpringApplication.run(BubbajdbcApplication.class, args);
  }
}
