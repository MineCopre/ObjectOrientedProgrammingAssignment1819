import logic.*;
import UI.*;

public class Main{

    public static void main(String[] args) {
        PlanetBound jogo = new PlanetBound();
        gameUI gameInterface =  new gameUI(jogo);
        gameInterface.run();
    }
}
