/* Created by Vince Chang */

package com.aliens.aliens;

public class Alien {
  private int id;
  private String name;
  private int points;

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return id;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setPoints(int points){
    this.points = points;
  }

  public int getPoints(){
    return points;
  }
}