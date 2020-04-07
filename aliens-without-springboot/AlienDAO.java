/* Created by Vince Chang */

// This class will deal with fetching data from the DB
public class AlienDAO{

	// Now using the DB
	List<Alien> listOfAliens;

	// For MySQL
	//Connection con = null;

	public AlienDAO(){

		// This is for mysql
		// String url = "jdbc:mysql://localhost:3306/";
		// con = DriverManager.getConnection(url);

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
	}

	public List<Alien> getAliens(){
		return listOfAliens;
	}


	public Alien getAlien(int id){
		for(Alien a : listOfAliens){
			if(a.getId() == id){
				return a;
			}
		}
		return null;
	}


	// This is a method that will work with a DB, but faking it here
	public void createAlien(Alien a){
		aliens.add(a1);
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
	}

	public void deleteAlien(int id){
		for(Alien alien : listOfAliens){
			if(alien.getId() == id){
				listOfAliens.remove(alien);
				break;
			}
		}
	}
}