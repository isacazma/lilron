package almereGym.tests;

import almereGym.model.PriveLes;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriveLesTest {
    PriveLes lesje;
    PriveLes lesjeTwee;
    User  kevin;

    @BeforeEach
    void init() {
        lesje = new PriveLes("springen");
        lesjeTwee = new PriveLes("lachen");
        almereGym.model.User kevin = new almereGym.model.User("b","b","manager",15);

    }
    @Test
    public void inschrijvenLes() {

        assertTrue(lesje.addUser(lesje, (almereGym.model.User) kevin));
    }

    @Test
    public void inschrijvenLesTwee() {
        User  q;
        int nr = 20;
        String naam = "a";
        String wachtwoord = "a";


       while(lesje.losseLessen.size() <= 61){
           almereGym.model.User  q = new User(naam,wachtwoord,"lid",nr);

       }

        assertFalse(lesje.addUser(lesje, (almereGym.model.User) kevin));
    }

//    @Test
//    void setTrainer() {
//
//        lesje.setTrainer("Kees de boer");
//        assertEquals("Kees de boer", lesje.getTrainer());
//
//    }
//
//    @Test
//    void setPrijs() {
//        lesje.setPrijs(40.00);
//        assertFalse(50.00, lesje.getPrijs());
//
//    }
//
//    private void assertFalse(double v, Double prijs) {
//    }
//
//    @Test
//    void setTitle() {
//        lesjeTwee.setTitle("ik hou toch van trainen");
//        assertEquals("ik hou toch van trainen" , lesjeTwee.getTitle());
//    }
//
//    @Test
//    void setBeschrijving() {
//        assertEquals("ik doe alsof ik kan boxen", lesjeTwee.getBeschrijving());
//    }
//
//    @Test
//    void getTrainer() {
//        assertEquals("bruceBee" , lesjeTwee.getTrainer());
//    }




}