package almereGym.webservices;


import almereGym.model.ProductBalie;
import almereGym.model.ProductBalieRequest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


@Path("nieuwBericht")
public class ProductBalieResource {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response NieuwBericht(ProductBalieRequest requestData) {

        String fullName = requestData.FullName;
        String bericht = requestData.Bericht;



        int s = ProductBalie.getAllProducten().size();


        ProductBalie newBericht = new ProductBalie(fullName + s , "nog niet klaar besteld op " + dtf.format(now),bericht);
        return Response.ok(newBericht).build();

    }

    @GET
    @Path("alleBerichtenTerug")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleBerichtenTerug() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = " Order Lijst ";
        jab.add(intro);

        for (ProductBalie p : ProductBalie.getAllProducten()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getFullName() + " STATUS ORDE: " + p.getStatus() ;
            job.add("Het bericht van ", bijde);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }
    @GET
    @Path("alleBerichtenTerugVol")
    @Produces(MediaType.APPLICATION_JSON)
    public String getalleBerichtenTerugVol() {

        JsonArrayBuilder jab = Json.createArrayBuilder();
        String intro = " Order Lijst ";
        jab.add(intro);

        for (ProductBalie p : ProductBalie.getAllProducten()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            String bijde = p.getFullName() + " STATUS ORDE: "+ p.getStatus() + " zijn order is " + p.getBericht() ;
            job.add("Het bericht van ", bijde);


//            job.add("numberOfLists", p.getAmountOfLists());
            jab.add(job);
        }

        JsonArray array = jab.build();
        return array.toString();

    }
    @Path("{name}")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchProduct(@PathParam("name") String oldName, @FormParam("newproductname") String newName) {
        ProductBalie product = ProductBalie.getUserByName(oldName);

//        if (product != null) {
//            if (!newName.isBlank()) {
        assert product != null;
        product.setStatus(" Afgerond: ");
        return Response.ok().build();
//            } else return Response.status(Response.Status.BAD_REQUEST).build();
//        } else return Response.status(Response.Status.NOT_FOUND).build();
    }

}

