package almereGym.webservices;
import almereGym.model.User;
import com.azure.core.annotation.PathParam;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("alleUsers")
public class AllUsersResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getShoppers() {
        User user = User.getUser();

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle users ";
        jab.add(intro);

        for (User p : User.getAllUser()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getName() + " en wachtwoord is " + p.getPass() + " en zijn rol is " + p.getRole();
            job.add("De User", bijde);


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
//@POST
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
//public Response addNieuweLeden(@FormParam("name") String name, @FormParam("pass")String pass, @FormParam("roll")String roll){
////    int aantalUsers = User.getAllUsers().size();
//    User newUser = new User(name,pass,roll); //Nieuwe shopper gemaakt
//
//    if(newUser == null) {
//        return Response.status(409)
//                .entity(new AbstractMap.SimpleEntry<>("error", "de  klan bestaat al!"))
//                .build(); //Het is niet gelukt, ik heb het onder elkaar gezet voor overzicht}
//    }
//    else{
//
//        return Response.ok(newUser).build(); //Stuur het resultaat altijd terug
//
//    }}


//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response addnieuweLeden(userRequest requestData) {
////        int aantalUsers = User.getAllUsers().size();
//        String naam = requestData.name;
//        String pas = requestData.pass;
//        String roll = requestData.roll;
//        if(roll == null){
//            roll = "lid";
//        }
//        User newUser = new User(naam, pas, roll); //Nieuwe shopper gemaakt
////        if (User.getAllUsers().size() > aantalUsers) { //Het is 1 opgehoogd en dus is het gelukt
//        return Response.ok(newUser).build(); //Stuur het resultaat altijd terug
////         else {
////
//
////                    .entity(new AbstractMap.SimpleEntry<>("error", "Shopper already exists!"))
////                    .build(); //Het is niet gelukt, ik heb het onder elkaar gezet voor overzicht
////        }
//
//    }

//int e=12;
//@GET
//@Path("{name}")
//@Produces(MediaType.APPLICATION_JSON)
//public String getShoppingListsFromPerson(@PathParam("name") String name) {
//    User shop = User.getUser();
//    JsonArrayBuilder jab = Json.createArrayBuilder();
////        List<ShoppingList> allListsFromPerson = shop.getListFromPerson(name); //warning: might return null!
////        if (allListsFromPerson == null)
////            return Json.createObjectBuilder()
////                    .add("error", "No owner with that name appearantly")
////                    .build()
////                    .toString();
////        else
////            allListsFromPerson.forEach(
////                    sl -> jab.add(
////                            Json.createObjectBuilder()
////                                    .add("name", sl.getName()));
//    jab.add(name);
//    return jab.build().toString();
//}
    @DELETE
   @Path("{id}")

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

//    public Response verwijderUser(@FormParam("name") String name, @FormParam("pass") String pass, @FormParam("roll") String roll) {
//        {
            public Response verwijderUser(@PathParam("id") String name) {
        for (User user : User.allUsers) {
            if (user.getName().equals(name)) {
                User.allUsers.remove(user);
                return Response.ok().build();
            } else {

//       return User.getName(s)
//                    ? Response.ok().build()
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
    return Response.ok().build();}}

//        int aantalUsers = User.getAllUsers().size();
//        String name = requestDataVoorWeg.name;
//        String pass = requestDataVoorWeg.pass;
//        String roll = requestDataVoorWeg.roll;
//            String patheje = name + pass + roll;
//            User u = getGeheleUser(name, pass, roll);
//            if(allUsers.contains(u)){
//                allUsers.remove(u);
//
//            }
//        if(User.getGeheleUserVerwijder(name, pass, roll)){
//            User.getGeheleUserVerwijder(name, pass, roll);
//            return Response.ok().build();
//

//        else
//            User.getGeheleUserVerwijder(name, pass, roll);
//        return Response.ok().build();
//            return Response.status(Response.Status.NOT_FOUND).build();




