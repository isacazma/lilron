package almereGym.Security;


import almereGym.model.User;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private User user;
    private String scheme;
    public MySecurityContext(User user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }
    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String s) {
        if (user.getRole().isEmpty()) {
            System.out.printf("%s equals %s", s, user.getRole());
            return s.equals(user.getRole());
        }
        return false;
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}