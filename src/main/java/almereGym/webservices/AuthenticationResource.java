package almereGym.webservices;



import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import almereGym.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

import static almereGym.model.User.onlineAllUsers;

@Path("login")
public class AuthenticationResource {

//    private static List<User> onlineAllUsers = new ArrayList<>();
//
//    public static List<User> getdit() {
//        return onlineAllUsers;
//    }

    public static final Key key = MacProvider.generateKey();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("gebruikersnaam") String name, @FormParam("wachtwoord")String pass){
        String role = User.validateLogin(name, pass);


        if (role == null) throw new IllegalArgumentException("No user found");

        if (role.equals("lid")) {
          User d =  User.getUserByName(name);
            if (!onlineAllUsers.contains(d)) {

                onlineAllUsers.add(d);
            }

            String token = createToken(name, role);
            return Response.ok(new SimpleEntry<>("JWT", token)).build();}
        else {
            throw new IllegalArgumentException("No user found");
        }        }




    private String createToken(String username, String role) throws JwtException {
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim(username, role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
