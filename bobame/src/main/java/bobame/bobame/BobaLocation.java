/* Created by Vince Chang */

package bobame.bobame;

public class BobaLocation {
  private int id;
  private String name;
  private String location;

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

  public void setLocation(String location){
    this.location = location;
  }

  public String getLocation(){
    return location;
  }
}