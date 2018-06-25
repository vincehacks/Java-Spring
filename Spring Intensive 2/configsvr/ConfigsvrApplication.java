// Created by Vince Chang
// This will be the configuration server

package com.macys.configsvr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigsvrApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConfigsvrApplication.class, args);
  }
}