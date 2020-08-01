/* Created by Vince Chang */

// This class will deal with fetching data from the DB
public class AlienDAO{

  // Now using the DB
  List<Alien> listOfAliens;

  // For MySQL
  //Connection con = null;

  public AlienDAO(){

    listOfAliens = new ArrayList<>();

    Alien a1 =  new Alien();
    a1.setId(1);
    a1.setName("Jaidyn");
    a1.setPoints(100);

    Alien a2 =  new Alien();
    a2.setId(2);
    a2.setName("Remi");
    a2.setPoints(200);

    listOfAliens.add(a1);
    listOfAliens.add(a2);

    // FOR MYSQL
    // String url = "jdbc:mysql://localhost:3306/NAME_OF_MYSQL_DATABASE";

    // // This is set up when the database is set up
    // String username = "root";
    // String password = "root";

    // try{
    //   // Load the driver
    //   Class.forName("com".mysql.jdbc.Driver)
    //   con = DriverManager.getConnection(url);
    // } catch(Exception e){
    //     System.out.println(e);
    // }

  }

  public List<Alien> getAliens(){
    return listOfAliens;
    // FOR MYSQL
    // List<Alien> listOfAliens = new ArrayList<>();
    // String sql = "SELECT * FROM alien";
    // try{
    //   Statement st = con.createStatement();
    //   ResultSet rs = st.executeQuery(sql);
    //   while(rs.next()){
    //     Alien a = new Alien();
    //     a.setId(rs.getInt(1));
    //     a.setName(rs.getString(2));
    //     a.setPoints(rs.getInt(3));
    //     listOfAliens.add(a);
    //   }

    // } catch(Exception e){
    //     System.out.println(e);
    // }
    // return listOfAliens;
  }


  public Alien getAlien(int id){
    for(Alien a : listOfAliens){
      if(a.getId() == id){
        return a;
      }
    }
    return null;

    // FOR MYSQL
    // String sql = "SELECT * FROM alien WHERE id=" + id;
    // Alien a = new Alien();
    // try{
    //   Statement st = con.createStatement();
    //   ResultSet rs = st.executeQuery(sql);
    //   if(rs.next()){
    //     a.setId(rs.getInt(1));
    //     a.setName(rs.getString(2));
    //     a.setPoints(rs.getInt(3));
    //   }

    // } catch(Exception e){
    //     System.out.println(e);
    // }
    // return a;

  }


  // This is a method that will work with a DB, but faking it here
  public void createAlien(Alien a){
    aliens.add(a1);

    // FOR MYSQL
    // String sql = "INSERT INTO alien VALUES (?,?,?)";
    // try{
    //   PreparedStatement st = con.prepareStatement();
    //   st.setInt(1, a.getId());
    //   st.setString(2, a.getName());
    //   st.setInt(3, a.getPoints());
    //   st.executeUpdate();

    // } catch(Exception e){
    //     System.out.println(e);
    // }
  }

  // MySQL with a framework called JDBC
  // JDBC video to find out what it is
  // Will need an import for sql and a MySQl Connector
  // mvn repository.com search for mysql connector & add dependency to pom.xml

  public void updateAlien(Alien a){
    for(Alien alien : listOfAliens){
      if(alien.getId() == a.getId()){
        alien.setName(a.getName());
        alien.setPoints(a.getPoints());
      }
    }

    // FOR MYSQL
    // String sql = "UPDATE alien SET name=?, points=?, WHERE id=?";
    // try{
    //   PreparedStatement st = con.prepareStatement();
    //   st.setString(1, a.getName());
    //   st.setInt(2, a.getPoints());
    //   st.setString(3, a.getId());
    //   st.executeUpdate();

    // } catch(Exception e){
    //     System.out.println(e);
    // }
  }

  public void deleteAlien(int id){
    for(Alien alien : listOfAliens){
      if(alien.getId() == id){
        listOfAliens.remove(alien);
        break;
      }
    }
    // FOR MYSQL
    // String sql = "DELETE alien WHERE id=?";
    // try{
    //   PreparedStatement st = con.prepareStatement();
    //   st.setInt(1, id);
    //   st.executeUpdate();

    // } catch(Exception e){
    //     System.out.println(e);
    // }
  }
}