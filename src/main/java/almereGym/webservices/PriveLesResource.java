package almereGym.webservices;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;

import almereGym.model.PriveLes;
import almereGym.model.PriveLesRequest;
import almereGym.model.User;

@Path("les")
public class PriveLesResource {


    @POST
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response inschrijvenLes(@FormParam("naamLes") String naamLes, @FormParam("name")String name,@FormParam("pass") String pass, @FormParam("role")String role)
//    {
    public Response inschrijvenLes(PriveLesRequest requestData ) {
        String name = requestData.name;
        String pas = requestData.pass;
        String role = requestData.role;
        String naamLes = requestData.naamLes;
        PriveLes dod = null;
        for (User user : User.getAllUser()) {
            if (user.getName().equals(name) && user.getRole().equals(role) && user.getPass().equals(pas)) {

                for (PriveLes priveLes : PriveLes.allPriveLes) {
                    if (priveLes.getNaam().equals(naamLes)) {
                        dod = priveLes;
                        if(!dod.losseLessen.contains(user)){
                            dod.losseLessen.add(user);

                            return Response.ok().build();
                        }}

                }



            }

        } return Response.status(Response.Status.NOT_FOUND).build();}

    @GET
    @Path("aantallessen")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleBerichtenTerug() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = "Alle Lessen ";
        jab.add(intro);

        for (PriveLes p : PriveLes.getAllPriveLes()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            int acht = 60 - p.losseLessen.size();
            String lessen = p.getNaam() + " en de aantal deelnemers  " + p.losseLessen.size() + " aantal plekken vrij voor deze les " + acht ;
            job.add("De les activiteit  ", lessen);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }}
