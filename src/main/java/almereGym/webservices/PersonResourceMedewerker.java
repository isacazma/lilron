package almereGym.webservices;

import almereGym.model.User;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("onlinemedewerker")
    public class PersonResourceMedewerker {


        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String getShoppers() {
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



    }






