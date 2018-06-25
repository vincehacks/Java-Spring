/* Created by Vince Chang
 * Instead of starting a webserver, we are going to be working from
 * the CommandLine! We are coding this (theClient) to make the rest call!
 */

package com.macys.theclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TheclientApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(TheclientApplication.class, args);
  }

  @Value("${message}")
  private String message;

  @Value("${resturl}")
  private String restendpoint;

  @Autowired
  private BubbaClient client;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Welcome to Boot CommandLine " + message);
    System.out.println("Application url is " + restendpoint);
    System.out.println(client.doTheBubba());
  }
}