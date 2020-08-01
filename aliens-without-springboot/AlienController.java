/* Created by Vince Chang */

// When this path is hit, this function will be called
@Path("aliens")
public class AlienController{

  AlienDAO repo = new AlienDao();

  // Retrieves ALL ALIENS from the DB
  // @Produces is what is returned, this is by Jersey which uses Moxy for
  // content negotiation. Because a list is returned, Moxy will resolve to a
  // JSON or XML
  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public List<Alien> getAliens(){
    return repo.getAliens();
  }

  // Retrieves ONE alien from the DB
  // @Produces is what is returned
  @GET
  @Path("alien/{id}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Alien getAlien(@PathParam("id") int id){
    return repo.getAlien(id);
  }

  // Adds data to the DB
  // @Consumes tell DB what it will format of data are you sending it
  @POST
  @Path("alien") // aliens/alien
  @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Alien createAlien(Alien a1){
    repo.createAlien(a1);
    return a1;
  }

  // Updates data to the DB
  // @Consumes tell DB what it will format of data are you sending it
  @PUT
  @Path("alien") // aliens/alien
  public void updateAlien(Alien a1){
    repo.updateAlien(a1);
  }

  // Updates data to the DB
  // @Consumes tell DB what it will format of data are you sending it
  @DELETE
  @Path("alien/{id}")
  public Alien deleteAlien(@PathParam("id") int id){
    Alien a = repo.getAlien(id);
    repo.deleteAlien(id);

    return a;
  }
}