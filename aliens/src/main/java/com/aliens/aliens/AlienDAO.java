/* Created by Vince Chang */

package com.aliens.aliens;

import java.util.ArrayList;
import java.util.List;

public class AlienDAO {

	// Now using the DB
	List<Alien> listOfAliens;

	// For MySQL
	//Connection con = null;

	/* =========================================================================
	* Function Name: constructor
	* Task: Initializes the listOfAliens and adds 2 Aliens to this list
		========================================================================= */
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

	/* =========================================================================
	* Function Name: getAliens
	* Task: Returns back a list of Aliens
		========================================================================= */
	public List<Alien> getAliens(){
		return listOfAliens;
	}

	/* =========================================================================
	* Function Name: getAlien
	* Task: Returns back a one alien that matches the id that is passed in
		========================================================================= */
	public Alien getAlien(int id){
		for(Alien a : listOfAliens){
			if(a.getId() == id){
				return a;
			}
		}
		return null;
	}

	/* =========================================================================
	* Function Name: createAlien
	* Task: Adds a alien to the list
		========================================================================= */
	public void createAlien(Alien a){
		listOfAliens.add(a);
	}

	// MySQL with a framework called JDBC
	// JDBC video to find out what it is
	// Will need an import for sql and a MySQl Connector
	// mvn repository.com search for mysql connector & add to dependency in the pom

	/* =========================================================================
	* Function Name: updateAlien
	* Task: Updates an Alien's information
		========================================================================= */
	public void updateAlien(Alien a){
		for(Alien alien : listOfAliens){
			if(alien.getId() == a.getId()){
				alien.setName(a.getName());
				alien.setPoints(a.getPoints());
			}
		}
	}

	/* =========================================================================
	* Function Name: deleteAlien
	* Task: Deletes the alien from the list
		========================================================================= */
	public void deleteAlien(int id){
		for(Alien alien : listOfAliens){
			if(alien.getId() == id){
				listOfAliens.remove(alien);
				break;
			}
		}
	}
}