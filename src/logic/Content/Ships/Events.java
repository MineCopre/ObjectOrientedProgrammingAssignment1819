package logic.Content.Ships;

import java.util.*;
import logic.Exception.*;
import Data.*;


public class Events {

    private gameData gameInfo;

    public Events(int event, gameData gameInfo) throws noFuelException, noCrewRemaining{
        this.gameInfo = gameInfo;
        switch (event) {
            case 0:
                crewDeath();
                break;
            case 1:
                addCargo();
                break;
            case 3:
                loseCargo();
                break;
            case 4:
                loseFuel();
                break;
            case 6:
                addCrew();
                break;
        }
    }

    public void crewDeath() throws noCrewRemaining{
        gameInfo.getShipType().crewDeath();
        gameInfo.addLog("You lost a crew member");
    }

    public void addCargo(){
        Random rand = new Random();
        String aux = new String();

        aux += "You found ";

        switch (rand.nextInt(4)) {
            case 0:
                gameInfo.getShipType().addCargo("Blue", 1);
                aux += "Blue cargo";
                break;
            case 1:
                gameInfo.getShipType().addCargo("Red", 1);
                aux += "Red cargo";
                break;
            case 2:
                gameInfo.getShipType().addCargo("Green", 1);
                aux += "Green cargo";;
                break;
            case 3:
                gameInfo.getShipType().addCargo("Black", 1);
                aux += "Black cargo";
                break;
        }
        gameInfo.addLog(aux);
    }

    public void loseCargo(){
        Random rand = new Random();
        String aux = new String();

        aux += "You lost ";

        switch (rand.nextInt(4)) {
            case 0:
                gameInfo.getShipType().removeCargo("Blue", 1);
                aux += "Blue cargo";
                break;
            case 1:
                gameInfo.getShipType().removeCargo("Red", 1);
                aux += "Red cargo";
                break;
            case 2:
                gameInfo.getShipType().removeCargo("Black", 1);
                aux += "Black cargo";
                break;
            case 3:
                gameInfo.getShipType().removeCargo("Green", 1);
                aux += "Green cargo";
                break;
        }
        gameInfo.addLog(aux);

    }
    public void loseFuel() throws noFuelException{
        gameInfo.getShipType().useFuel(1);
        gameInfo.addLog("You lost a fuel unit");
    }

    public void addCrew() {
        gameInfo.getShipType().addCrew();
        gameInfo.addLog("You won a crew member");
    }
}
