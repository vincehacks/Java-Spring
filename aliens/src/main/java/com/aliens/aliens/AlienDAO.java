/* Created by Vince Chang */

package com.aliens.aliens;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienDAO {

  // Creating a Connection object to connect to MySQL database
  Connection con = null;

  /* =========================================================================
  * Function Name: constructor
  * Task: Uses JDBC is the API to connect to MySQL database
  * DriverManger.getConnection() is a static method that will return an instance
  * of a Connection object, provided the url, username, and password to the DB
  *
  * Class.forName() will automatically Load the class and call its static method
  * The static method that is called will do this snippet of code which is to
  * Register the driver
  * DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)
  * because I am forcing this static method to be called by doing
  * Class.forName("com.mysql.cj.jdbc.Driver"), I do not need to Register it
  * myself therefore, do not need to include that part!
    ========================================================================= */
  public AlienDAO(){

    // THIS DID NOT WORK (I THINK BECAUSE DIFFERENT VERSION)
    // String url = "jdbc:mysql://localhost:3306/restdb?autoReconnect=true&useSSL=false";

    // THIS WORKS!
    String url = "jdbc:mysql://localhost:3306/restdb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";

    String username = "root";
    String password = "adminadmin";

    // Will need to be in a try catch block
    try{
      // Loading a driver and getting a connection object to MySQL DB
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url,username,password);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

  /* =========================================================================
  * Function Name: getAliens
  * Task: Returns back a list of Aliens by using JDBC.
  * STEPS:
  *		1. Create a SQL statement as a string
  * 	2. In a try catch block, use Connection object to create a Statement
  * 	object and then use the Statement object to execute the SQL query from
  * 	step 1
  *   3. Step 2 will return a Result set, so will need to use a while loop to
  *   iterate over everything in the set. In this case, for each row, will
  *   create a new Alien object and add this to the list
  *
  * Important to know that rs.next() will tell move the pointer down to the
  * next element. This is needed for testing and singling out things from DB
    ========================================================================= */
  public List<Alien> getAliens(){

    List<Alien> aliens = new ArrayList<>();
    String sql = "SELECT * FROM alien";

    try{
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        Alien a = new Alien();
        // These get methods take a column number to get the value
        // 1 = column 1, etc..
        a.setId(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setPoints(rs.getInt(3));

        aliens.add(a);
      }
    }
    catch(Exception e){
      System.out.println(e);
    }

    return aliens;
  }

  /* =========================================================================
  * Function Name: getAlien
  * Task: Returns back a one alien that matches the id that is passed in
  * STEPS:
  *		1. Create a SQL statement as a string
  * 	2. In a try catch block, use Connection object to create a Statement
  * 	object and then use the Statement object to execute the SQL query from
  * 	step 1
  *   3. Step 2 will return a Result set, DO NOT NEED A WHILE LOOP because will
  *   only need to get one value back from the DB
  * Note that the execute statement is executeQuery()
    ========================================================================= */
  public Alien getAlien(int id){

    String sql = "SELECT * FROM alien WHERE id=" + id;
    Alien a = new Alien();

    try{
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      if(rs.next()){
        a.setId(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setPoints(rs.getInt(3));
      }
    }
    catch(Exception e){
      System.out.println(e);
    }

    return a;
  }

  /* =========================================================================
  * Function Name: createAlien
  * Task: Adds a alien to the DB using a PreparedStatement object
  * Using a PreparedStatement because it will replace the question marks by
  * using teh Alien object I passed in to fill those values
  ========================================================================= */
  public void createAlien(Alien a){

    // Instead of doing this below, utilize a PreparedStatement from java.sql
    // You can use ? as a placeholder !!!
    // String sql = "INSERT INTO alien VALUES ("  + a.getId() + ", " + a.getName()
    // + ", " a.getPoints() + ")";

    String sql = "INSERT INTO alien VALUES (?,?,?)";

    try{
      // The PreparedStatement takes the sql query right away vs a Statement obj
      PreparedStatement st = con.prepareStatement(sql);
      // Replacing the ? now in the sql string
      st.setInt(1, a.getId());
      st.setString(2,a.getName());
      st.setInt(3,a.getPoints());
      st.executeUpdate();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }


  /* =========================================================================
  * Function Name: updateAlien
  * Task: Updates an Alien's information in the DB
  * Take note that the Execute function is now executeUpdate()
  ========================================================================= */
  public void updateAlien(Alien a){

    String sql = "UPDATE alien SET name=?, points=? WHERE id=?";

    try{
      // The PreparedStatement takes the sql query right away vs a Statement obj
      PreparedStatement st = con.prepareStatement(sql);
      // Replacing the ? now in the sql string
      st.setString(1,a.getName());
      st.setInt(2,a.getPoints());
      st.setInt(3,a.getId());
      st.executeUpdate();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }

  /* =========================================================================
  * Function Name: deleteAlien
  * Task: Deletes the alien from the DB
  ========================================================================= */
  public void deleteAlien(int id){

    String sql = "DELETE FROM alien WHERE id=?";

    try{
      // The PreparedStatement takes the sql query right away vs a Statement obj
      PreparedStatement st = con.prepareStatement(sql);
      // Replacing the ? now in the sql string
      st.setInt(1,id);
      st.executeUpdate();
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}