package almereGym.webservices;
import almereGym.model.Berichten;
import almereGym.model.User;
import almereGym.model.berichtRequest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static almereGym.model.Berichten.getAllBerichetn;
import static almereGym.model.User.getAllUser;

@Path("online")
public class OnlineResource {


    @GET
    @Path("medewerker")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMedewerker() {
        User user = User.getUser();

        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (User p : User.getDitMedewerker()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("De online medewerker ", p.getName());


            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }

    @GET
    @Path("lid")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        User user = User.getUser();

        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (User p : User.getdit()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("De online lid is ", p.getName());

//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }

    @GET
    @Path("alleUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleUsers() {
        User user = User.getUser();

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle users ";
        jab.add(intro);

        for (User p : getAllUser()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getName() + " en wachtwoord is " + p.getPass() + " en zijn rol is " + p.getRole()+ " en zijn nr " + p.getNr();
            job.add("De User", bijde);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }

    @POST
    @Path("nieuwLid")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addnieuweLeden(userRequest requestData) {
//        int aantalUsers = User.getAllUsers().size();
        String naam = requestData.name;
        String pas = requestData.pass;
        String roll = requestData.roll;
        if(roll == null){
            roll = "lid";
        }
        User newUser = new User(naam, pas, roll,getAllUser().size() + 1);
        return Response.ok(newUser).build();

    }


    @POST
    @Path("nieuwLidMedewerker")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addnieuweLedenMedewerker(userRequest requestData) {
        String naam = requestData.name;
        String pas = requestData.pass;
        String roll = "lid";



        User newUser = new User(naam, pas, roll,getAllUser().size() + 1);
        return Response.ok(newUser).build();

    }


    @POST
    @Path("nieuwBericht")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response NieuwBericht(berichtRequest requestData) {

        String fullName = requestData.FullName;
        String email = requestData.Email;
        String reden = requestData.Reden;
        String bericht = requestData.Bericht;



        Berichten newBericht = new Berichten(fullName, email, reden,bericht);
        return Response.ok(newBericht).build();

    }

    @GET
    @Path("lidOnlineKeuze")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserskeuze() {
        User user = User.getUser();

        JsonArrayBuilder jab = Json.createArrayBuilder();
        int een = 0;
        for (User p : User.getdit()) {
            een ++;



        }
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("Er zijn zo veel personen momenteel in de sportschol   ", een);
        jab.add(job);
        JsonArray array = jab.build();
        return array.toString();

    }



    @GET
    @Path("alleBerichtenTerug")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleBerichtenTerug() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle Berichten ";
        jab.add(intro);

        for (Berichten p : getAllBerichetn()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getFullName() + " en email is " + p.getEmail() + " en zijn rede " + p.getReden()+ " Bericht " + p.getBericht();
            job.add("Het bericht van ", bijde);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }
//    @GET
//    @Path("{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getShoppingListsFromPerson(@PathParam("name") String name) {
//        Shop shop = Shop.getShop();
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//        List<ShoppingList> allListsFromPerson = shop.getListFromPerson(name); //warning: might return null!
//        if (allListsFromPerson == null)
//            return Json.createObjectBuilder()
//                    .add("error", "No owner with that name appearantly")
//                    .build()
//                    .toString();
//        else
//            allListsFromPerson.forEach(
//                    sl -> jab.add(
//                            Json.createObjectBuilder()
//                                    .add("name", sl.getName())));
//        return jab.build().toString();
//    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addShopper(userRequest requestData) {
//        int aantalUsers = User.getAllUsers().size();
//        User newUser = new User(requestData.name,requestData.pass,requestData.roll); //Nieuwe shopper gemaakt
//        if (User.getAllUsers().size() > aantalUsers) { //Het is 1 opgehoogd en dus is het gelukt
//            return Response.ok(newUser).build(); //Stuur het resultaat altijd terug
//        } else {
//            return Response.status(409)
//                    .entity(new AbstractMap.SimpleEntry<>("error", "Shopper already exists!"))
//                    .build(); //Het is niet gelukt, ik heb het onder elkaar gezet voor overzicht
//        }
//
//    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deletePerson(@PathParam("name") String name) {
//        if(Shopper.removeShopper(name))
//            return Response.ok().build();
//        else
//            return Response.status(Response.Status.NOT_FOUND).build();
//    }
}




