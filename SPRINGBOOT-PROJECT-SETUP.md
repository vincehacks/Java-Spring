# PROJECT SET UP: SPRING BOOT + MYSQL DB

Created by Vince Chang </br>

This will inform how to create a Spring Boot Web REST API with MySQL database.

#### CREATE A NEW SPRING BOOT PROJECT WITH VSCODE

1. Open up **java overview** from command pallet `cmd + shift + p`
2. Click on **Create a Spring Boot Project**
3. Follow wizard to set up choose:

- Maven Project
- Java
- Fill in package name and artifact id
- Choose the latest Spring boot version
- Search and select `Spring Web` not `Spring Reactive Web`
- Automatically this is added to the `pom.xml`

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
```

4. Choose appropriate location of where to set up project

5. Set up MYSQL DB (Follow next section)
6. Spring-Boot Dashboard will automatically pick up that this is a new Spring
   Boot project so you can use the dashboard to Start the project
7. Wire Spring Boot and MySQL (Follow third section)

- If this does not work clean the workspace:
  - `cmd + shift + p`
  - Search for `Java: Clean the Java language server workspace`
  - You should see the project now appear under Spring-Boot Dashboard

#### SET UP MYSQL DB

1. Open up MYSQL Workbench
2. Local Instance 3306 should already been installed, click on that

- When setting up this instance, there should have been a `username` and
  `password` generated that will be explained how to use in the next section

3. Right click under the **SCHEMAS** section and `Create Schema`

- Pass in name, then apply

4. A new table should have been created

- Expand and right click on Tables and `Create Table`
- Fill in fields: PK = Primary Key, NN = Not Null, AI = Auto Increment

#### WIRE SPRING BOOT AND MYSQL DB

1. Under the DAO of this application, you will need to use a `String url` to
   connect to the database
2. The URL has to pass in the name of the schema, this example is `bobamedb`
   `String url = "jdbc:mysql://localhost:3306/bobamedb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";`

- Can just replace the schema name with your schema name

3. Lastly use Spring-Boot Dashboard to fire up the project
4. Use Postman to confirm that the API can create, delete, update, in the DB!

```java
public class BobaLocationDAO {

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
  * Register the driver:
  * DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)
  * because I am forcing this static method to be called by doing
  * Class.forName("com.mysql.cj.jdbc.Driver"), I do not need to Register it
  * myself therefore, do not need to include that part!
    ========================================================================= */
  public BobaLocationDAO(){

    // THIS DID NOT WORK (I THINK BECAUSE DIFFERENT VERSION)
    // String url = "jdbc:mysql://localhost:3306/restdb?autoReconnect=true&useSSL=false";

    // THIS WORKS!
    String url = "jdbc:mysql://localhost:3306/bobamedb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";

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
```
