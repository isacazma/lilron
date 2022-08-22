package almereGym.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.bep.shopping.webservices","nl.hu.bep.shopping.setup","nl.hu.bep.shopping.Security");
        register(RolesAllowedDynamicFeature.class);
    }
}

