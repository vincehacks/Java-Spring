// Created by Vince Chang
// This file has all the REST commands and routes

package com.example.bubba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// This annotation defines my Rest Service
@RestController
public class BubbaResource {

  // This annotation goes to TheService.java and intiantiates a TheService obj
  // Equivalent to private TheService svc = new TheService();
  @Autowired
  private TheService svc;

  // Short hand annotation for GET, will resolve to a call in TheService.java
  @GetMapping("/bubbamsg")
  public String doTheBubba() {
    return svc.doTheService();
  }

  // Short hand annotation for REQUEST
  @RequestMapping(method=RequestMethod.GET,path="/thebubba")
  public BubbaBody getTheBubba() {
    return new BubbaBody("Bubba","BubbaCity","Blue",80,"Vanilla");
  }
}