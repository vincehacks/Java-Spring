/******************************************************************************
Created by Vince Chang

This is the Beans implementation, that will ALWAYS implement an interface!
******************************************************************************/

package com.di.helloworld;

public class HelloSpringBean implements HelloSpring {

  String message;

  public void setMessage(String m){
    this.message = m;
  }

  public String getMessage() {
    return this.message;
  }
}