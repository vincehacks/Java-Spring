# Alien REST API

Created by Vince Chang </br>

Spring Boot application built to deal with Aliens. This project creates a REST
API to create, read, update and delete Aliens from MySQL database using the
jdbc API.

#### JDBC = Java Database Connectivity

- This is how java applications can connect to a database using 7 steps
- The best analogy is when you want to call your friend on the phone, you will
  need a connection look at the equivalence below

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
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
				<version>8.0.19</version>
		</dependency>
```

- The second part to this to to **Register**
- Class.forName() will automatically Load the class and call its static method
- The static method that is called will do this snippet of code which is to
  Register the driver `DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)`
  because I am forcing this static method to be called by doing
  `Class.forName("com.mysql.cj.jdbc.Driver")`, I do not need to Register it
  myself therefore, do not need to include that part!
- This constructor is needed for getConnection to work

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
   - **PreparedStatement**: used when you need to create a query with values that
     will be substituted with information that is passed in from a parameter
   - **CallableStatement**: used for stored procedures
5. Execute the Query (Say it)
   - This will go out to the DB to do the query that was build in step 4

```java
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery(sql);
```

6. Process Results (Acknowledge what you said)
7. Close (Conversation over)

#### Java on my Mac

- `/Library/Java/JavaVirtualMachines/<version>/Contents/Home/`

#### How to Test MySQL from terminal

- MySQL location: `/usr/local/mysql`
- From here can run the commands just outside the `bin` folder
- [MySQL from Terminal](https://dev.mysql.com/doc/refman/8.0/en/testing-server.html)

#### Troubles Encountered

1. Versions of MySQL connector was not compatible with MySQL 8

- Now both versions match
  - mysql-connector-java is running on 8.0.19
  - MySQL running on 8.0.19

2.  Connecting to the database was a challenge using the new version of connector

- [Troubleshooting DB connection](https://stackoverflow.com/questions/50382824/mysqlnontransientconnectionexception-could-not-create-connection-to-database-ser)

```java
// This is the correct way to connect
String url = "jdbc:mysql://localhost:3306/restdb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
```

3. Syntax on how to use Spring Boot Annotations for REST APIs
