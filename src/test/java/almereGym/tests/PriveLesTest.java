package almereGym.tests;

import almereGym.model.PriveLes;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static almereGym.model.PriveLes.verwijderLes;
import static almereGym.model.PriveLes.verwijderlosseLessen;
import static almereGym.model.User.*;
import static org.junit.jupiter.api.Assertions.*;

class PriveLesTest {
    PriveLes lesje;
    PriveLes lesjeTwee;
    almereGym.model.User kevin;
    User  q;

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
    public void lesVerwijderen() {

        assertTrue(verwijderLes(lesje));
    }

    @Test
    public void lesVerwijderenTwee() {
        verwijderLes(lesje);
        assertFalse(verwijderLes(lesje));
    }



    @Test
    public void lesVerwijderenDrie() {
        lesje.addUser(lesje, (almereGym.model.User) kevin);
        assertTrue(verwijderlosseLessen(kevin,lesje));
    }

    @Test
    public void lesVerwijderenVier() {

        assertFalse(verwijderlosseLessen(kevin,lesje));
    }



}