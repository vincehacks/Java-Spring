/* Created by Vince Chang */

package com.aliens.aliens;

import java.util.List;

import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;
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

	// Updates an alien in the DB
	@PutMapping
	public void updateAlien(Alien a1){
		repo.updateAlien(a1);
	}

	// Deletes an alien from the DB
	@DeleteMapping
	public Alien deleteAlien(@PathVariable("id") int id){
		Alien a = repo.getAlien(id);
		repo.deleteAlien(id);
		return a;
	}
}