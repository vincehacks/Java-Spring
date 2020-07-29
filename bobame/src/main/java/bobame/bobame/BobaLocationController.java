/* Created by Vince Chang */

package bobame.bobame;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Note: Jackson is brought in as a Maven dependency and this does the
// conversion of list of objects into JSON
@RestController
public class BobaLocationController {

  BobaLocationDAO repo = new BobaLocationDAO();

  // Retrieves ALL BobaLocations from the DB
  @GetMapping("BobaLocations")
  public List<BobaLocation> getBobaLocations(){
    return repo.getBobaLocations();
  }

  // Retrieves ONE BobaLocation from the DB
  @GetMapping("BobaLocation/{id}")
  public BobaLocation getBobaLocation(@PathVariable("id") int id){
    return repo.getBobaLocation(id);
  }

  // Adds an BobaLocation to the DB
  @PostMapping("BobaLocation")
  public BobaLocation createBobaLocation(@RequestBody BobaLocation a1){
    repo.createBobaLocation(a1);
    return a1;
  }

  // Updates an BobaLocation in the DB, creates a new BobaLocation of id does not exist!
  @PutMapping("BobaLocation")
  public BobaLocation updateBobaLocation(@RequestBody BobaLocation a1){
    if(repo.getBobaLocation(a1.getId()).getId() == 0)
      repo.createBobaLocation(a1);
    else
      repo.updateBobaLocation(a1);

    return a1;
  }

  // Deletes an BobaLocation from the DB, if it's in the DB
  @DeleteMapping("BobaLocation/{id}")
  public BobaLocation deleteBobaLocation(@PathVariable("id") int id){

    BobaLocation a = repo.getBobaLocation(id);

    if(a.getId() > -1)
      repo.deleteBobaLocation(id);

    return a;
  }
}