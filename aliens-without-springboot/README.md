# ALIEN REST API USING JERSEY

Created by Vince Chang </br>

Jersey application built to deal with Aliens. This project creates a REST
API to create, read, update and delete Aliens.

#### STARTING UP A JERSEY PROJECT

- Tomcat needs to be installed and running for it to serve the webapp
- Use the IDE to run the project
- Should go to `http://localhost:8080/myresource` to see the project
- Might need to go to `WEB-INF/web.xml` to see `<url-pattern>` which will say
  `/webapi`.
- This will change the url to `http://localhost:8080/webapi/myresource`
- Can remove this part to remove `webapi` from the url

#### HOW TO CREATE A RESOURCE CLASS

- `Alien.java` is a simple POJO class
- `@XmlRootElement`
  - Need to define this object as the XML Root Element

### THE CONTROLLER

- `AlienController.java` is the Controller of this application
- `@Path("aliens")`
  - This is the annotation of where to go when a GET request is fired
- `http://localhost:8080/demohost/webapi/aliens`

#### GET

- When you return something you need to mention what it `@Produces`
- `@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})`
  - This will tell you what the GET request is going to return back
  - By passing in JSON and XML, you can get a response of both
  - This is known as **content negotiation**
  - The dependency for this is `jersey-media-moxy`

#### POST

- `@Path("alien/{id}")` Retrieving one alien
  - `{id}` is a path parameter that will be passed in
  - In the java code will need to use the annotation `@PathParam`
  ```java
  @GET
  @Path("alien/{id}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Alien getAlien(@PathParam("id") int id){
    return repo.getAlien(id);
  }
  ```
  - `@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})`
  - This is for Posting data, the difference is the annotation `@Consumes`

#### UPDATE/DELETE

- `@PUT` and `@DELETE` do not need any extra annotation

### THE REPO AKA THE DAO

- `AlienDAO.java` will be the repo or the DAO that works with the database
- Once the requests are made from the webapp in the Controller, the Controller
  delegates the DAO to retrieve data from the database.
- In this example, there is no database, so the DAO will just use data
  structures to spoof what a database will return

#### JDBC = JAVA DATABASE CONNECTIVITY

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

- This implementation will be in the DAO class
- Need to create a `Connection` object that will open the connection to
  the database, will look something like this:

```java
public class AlienDAO{

  // Now using the DB
  List<Alien> listOfAliens;

  // For MySQL
  Connection con = null;

  public AlienDAO(){

    // This is for mysql
    String url = "jdbc:mysql://localhost:3306/NAME_OF_MYSQL_DATABASE";

    // This is set up when the database is set up
    String username = "root";
    String password = "root";

    try{
      // Load the driver
      Class.forName("com".mysql.jdbc.Driver)
      con = DriverManager.getConnection(url);
    } catch(Exception e){
        System.out.println(e);
    }
  }
```

- The second part to this is to **Register**
- `Class.forName()` will automatically Load the class and call its static method
- The static method that is called will do this snippet of code which is to
  Register the driver `DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver)`
  because I am forcing this static method to be called by doing
  `Class.forName("com.mysql.cj.jdbc.Driver")`, I do not need to Register it
  myself therefore, do not need to include that part!
- This constructor is needed for `getConnection` to work

#### GETTING FROM THE DATABASE

```java
  public List<Alien> getAliens(){
    List<Alien> listOfAliens = new ArrayList<>();
    String sql = "SELECT * FROM alien";
    try{
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        Alien a = new Alien();
        a.setId(rs.getInt(1));
        a.setName(rs.getString(2));
        a.setPoints(rs.getInt(3));
        listOfAliens.add(a);
      }

    } catch(Exception e){
        System.out.println(e);
    }
    return listOfAliens;
  }

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

    } catch(Exception e){
        System.out.println(e);
    }
    return a;
  }
```

#### PUTTING INTO THE DATABASE

```java
  public void createAlien(Alien a){
    String sql = "INSERT INTO alien VALUES (?,?,?)";
    try{
      PreparedStatement st = con.prepareStatement();
      st.setInt(1, a.getId());
      st.setString(2, a.getName());
      st.setInt(3, a.getPoints());
      st.executeUpdate();

    } catch(Exception e){
        System.out.println(e);
    }
  }
```

#### UPDATING THE DATABASE

```java
  public void updateAlien(Alien a){
    String sql = "UPDATE alien SET name=?, points=?, WHERE id=?";
    try{
      PreparedStatement st = con.prepareStatement();
      st.setString(1, a.getName());
      st.setInt(2, a.getPoints());
      st.setString(3, a.getId());
      st.executeUpdate();

    } catch(Exception e){
        System.out.println(e);
    }
  }
```

#### DELETING DATA IN THE DATABASE

```java
  public void deleteAlien(int id){
    String sql = "DELETE alien WHERE id=?";
    try{
      PreparedStatement st = con.prepareStatement();
      st.setInt(1, id);
      st.executeUpdate();

    } catch(Exception e){
        System.out.println(e);
    }
  }
```

### SENDING THE HEADER RESPONSE BACK

- You can send the status of the response, using a **Response Builder**
- With this, you can modify the status code and header information
- Can set cookies, encoding etc. Just call the function

```java

Alien alien = new Alien();

@POST
public Response addAlien(Alien a, @Context UriInfo uriInfo){
  Alien newAlien = alien.createAlien(a)

  // This is the example of how to do a hardcoded way
  //return Response.created(new URI("/aliens/alien/" + a.getAlien()));

  // This is now using the URI to get the info
  // The getAbsolutePathBuilder() will append the alien id to
  // /aliens/alien + alien ID
  URI uri = uriInfo.getAbsolutePathBuilder().path(a.getId());
  return Response.created(uri);
    .entity(newAlien)
    .build();
}
```

### ERROR HANDLING

1. Create an `ExceptionMapper`, takes a Type of exception
2. Implement the `toResponse` method to return a `Response`
3. Send Response back, `ErrorMessage`, response codes, etc
