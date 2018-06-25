// Created by Vince Chang

package com.example.bubba;

public class BubbaBody {

  private String name;
  private String city;
  private String favColor;
  private String favIceCream;
  private int age;

  // Constructor
  public BubbaBody(String name, String city, String favColor, int age,
  String favIceCream) {
    super();
    this.name = name;
    this.city = city;
    this.favColor = favColor;
    this.age = age;
    this.favIceCream = favIceCream;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getFavColor() {
    return favColor;
  }
  public void setFavColor(String favColor) {
    this.favColor = favColor;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getFavIceCream() {
    return favIceCream;
  }
  public void setFavIceCream(String favIceCream) {
    this.favIceCream = favIceCream;
  }
}