package almereGym.model;

import java.util.ArrayList;

public class LijstSpellen {
    public static ArrayList<Spel> getAlleSpellen() {
        return alleSpellen;
    }

    public static void setAlleSpellen(ArrayList<Spel> alleSpellen) {
        LijstSpellen.alleSpellen = alleSpellen;
    }

    public static ArrayList<Spel> alleSpellen = new ArrayList<Spel>();

    public void addGame(Spel spel){
        alleSpellen.add(spel);
};}
