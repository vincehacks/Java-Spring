/* Created by Vince Chang */

package com.aliens.aliens;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienController {

  AlienDAO repo = new AlienDAO();

	// Retrieves ALL ALIENS from the DB
	@GetMapping("aliens")
	public List<Alien> getAliens(){
		return repo.getAliens();
	}

	// Retrieves ONE alien from the DB
	@GetMapping("alien/{id}")
	public Alien getAlien(@PathVariable("id") int id){
		return repo.getAlien(id);
	}

	// Adds an alien to the DB
	@PostMapping("alien")
	public Alien createAlien(@RequestBody Alien a1){
		repo.createAlien(a1);
		return a1;
	}

	// Updates an alien in the DB, creates a new alien of id does not exist!
	@PutMapping("alien")
	public Alien updateAlien(@RequestBody Alien a1){
		if(repo.getAlien(a1.getId()).getId() == 0)
			repo.createAlien(a1);
		else
			repo.updateAlien(a1);

		return a1;
	}

	// Deletes an alien from the DB, if it's in the DB
	@DeleteMapping("alien/{id}")
	public Alien deleteAlien(@PathVariable("id") int id){

		Alien a = repo.getAlien(id);

		if(a.getId() != 0)
			repo.deleteAlien(id);

		return a;
	}
}