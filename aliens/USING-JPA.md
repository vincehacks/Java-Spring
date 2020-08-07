# ALIEN REST API USING SPRING BOOT JPA

Created by Vince Chang </br>

Spring Boot application built to deal with Aliens. This project creates a REST
API to create, read, update and delete Aliens from MySQL database using the
JDBC API and JPA.

JPA will do all the heavy lifting where I would not need to implement the
C.R.U.D operations. This README will explain that.

#### INSTALLING JPA

1. Open up **java overview** from command pallet `cmd + shift + p`
2. Click on **Create a Spring Boot Project**
3. Follow wizard to set up choose:

- Maven Project
- Java
- Fill in package name and artifact id
- Choose the latest Spring boot version
- Search and select `Spring Web` not `Spring Reactive Web`
- Search and select `Spring Data JPA`
- Automatically this is added to the `pom.xml`

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
```

1. Import the package (Need a phone to use)
   - `import java.sql*`
2. Load and register the Driver (Need a network call will go over)
   - There are different Drivers for different DBs
   - MySQL uses `com.mysql.cj.jdbc.Driver`
   - Need to also add the dependency to the `pom.xml`
   - Go to https://mvnrepository.com/ and search for **mysql connector**
   - Choose the version that matches the version of MySQL DB, at the time
     of this project, I am using **8.0.19** for both mysql-connector & MySQL DB

```xml
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.19</version>
  </dependency>
```

- The second part to this is to **Register**
- `Class.forName()` will automatically Load the class and call its static method
- The static method that is called will do this snippet of code which is to
  Register the driver `DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)`
  because I am forcing this static method to be called by doing
  `Class.forName("com.mysql.cj.jdbc.Driver")`, I do not need to Register it
  myself therefore, do not need to include that part!
- This constructor is needed for `getConnection` to work

```java
  /* =========================================================================
  * Function Name: constructor
  * Task: Uses JDBC is the API to connect to MySQL database
  * DriverManger.getConnection() is a static method that will return an instance
  * of a Connection object, provided the url, username, and password to the DB
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

  //... then later on can use this like so: refer to AlienDAO.java
  // Loading a driver and getting a connection object to MySQL DB
  Class.forName("com.mysql.cj.jdbc.Driver");
  con = DriverManager.getConnection(url,username,password);
```

3. Establish the Connection (Call the friend)
   - Create an instance of a Connection object as a global object so I can
     reuse the same object in multiple functions
   - `Connection con = null;`
4. Create the Statement Object (Think about what to say)
   - **3 Types: Statement, PreparedStatement, CallableStatement**
   - **Statement**: usually used for GETs
   - **PreparedStatement**: used when you need to create a query with values
     that will be substituted with information that is passed in from a
     parameter
   - **CallableStatement**: used for stored procedures
5. Execute the Query (Say it)
   - This will go out to the DB to do the query that was build in step 4

```java
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery(sql);
```

6. Process Results (Acknowledge what you said)
7. Close (Conversation over)

#### USING JPA & HIBERNATE TO IMPLEMENT C.R.U.D IN ALIENDAO.JAVA

1. Create a Interface that `extends CrudRepository` and DO NOT NEED TO WRITE ANY
   IMPLEMENTATION! LEAVE IT EMPTY!

Originally, you have to implement all of the methods to talk to the database
here like getAliens(), updateAlien(), deleteAlien(), etc., but now the
extension of this interface makes all of it possible without any implementation!

```java
// AlienDAO.java
import org.springframework.data.repository.CrudRepository;

// CrudRepository<ClASS,PRIMARY_KEY_TYPE>
public interface AlienDAO extends CrudRepository<Alien,Integer>{

}
```

2. In the Controller (`AlienController.java`), create a new instance of the
   AlienDAO and have the annotation of `@Autowired`

- `@Autowired` will search for the implementation of AlienDAO and know what to
  refer to!

```java
@Autowired
AlienDAO repo;

// Therefore you can do something like this:

@GetMapping("aliens")
public List<Alien> getAliens(){
  List<Alien> alien = (List<Alien>) repo.findAll();
  return aliens;
}
```

#### HOW TO RUN THE PROJECT

1. From the root directory, you can build and install all dependencies by
   running this Maven command from the terminal:

`mvn clean package`

2. Use Spring Dashboard to run the project
