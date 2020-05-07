package Data;

import java.util.*;
import logic.Content.Ships.*;
import logic.Content.Planets.*;
import logic.Content.SurfaceMining.*;
import logic.Exception.*;

public class gameData {

    private Ship shipType;
    private Planet planetType;
    private Alien alien;
    private Drone drone;
    private ArrayList<String> logs;
    private String lastMove;
    private int nextAlien;

    public void addLog(String log) { logs.add(log); }

    public void clearLogs(){
        logs.clear();
    }

    public boolean checkLogs(){
        if(logs.size() > 0)
            return true;
        return false;
    }

    public List<String> getLogs(){
        return logs;
    }

    public gameData(){
        logs = new ArrayList<String>();
    }

    public Ship getShipType() { return shipType; }

    public Drone getDrone() {return drone;}

    public Alien getAlien() {return alien;}

    public void setShipType(Ship shipType) { this.shipType = shipType; }

    public Planet getPlanetType() { return planetType; }

    public void setPlanetType(Planet planetType) { this.planetType = planetType; }

    public void moveWormhole() throws noFuelException, noCrewRemaining{ getShipType().moveWormhole(); }

    public void move() throws noFuelException{ getShipType().move(); }

    public void sortPlanetResource(){ addLog("You're going to mine the " + planetType.sortPlanetResource() + " resource"); }

    public void sortAlienType(){
        alien = new Alien();
        addLog("A wild " + alien.getAlienType() + " alien appeared");
    }

    public void sortLocations(){

        alien.setPosAlien();

        do {
            shipType.setPosShip();
        }while(shipType.getPosShip().equals(alien.getPosAlien()));

        drone = new Drone(shipType.getPosShip());

        do{
            planetType.setPosResource();
        }while(planetType.getPosResource().equals(alien.getPosAlien()) || planetType.getPosResource().equals(shipType.getPosShip()));

        lastMove = "Drone";
    }

    public void setNextAlien(){
        Random rand = new Random();

        nextAlien = rand.nextInt(6)+1;

    }

    public int sortAmountResource(){
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }

    public void drawBoard(){
        String aux = new String();
        for(int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (alien != null && alien.getPosAlien().get(0) == j && alien.getPosAlien().get(1) == i)
                        aux += "A ";
                else
                    if(drone.getPosDrone().get(0) == j && drone.getPosDrone().get(1) == i)
                    aux += "D ";
                else
                if(shipType.getPosShip().get(0) == j && shipType.getPosShip().get(1) == i)
                    aux += "S ";
                else
                if(planetType.getPosResource().get(0) == j && planetType.getPosResource().get(1) == i)
                    aux += "R ";
                else
                    aux += "| ";

            }
            aux += "\n";
        }
        addLog(aux);
    }

    public String nextTurn(){

        battleTurn turn = new battleTurn(this);

        String direction;

        if(nextAlien > 0 && alien != null)
            sortAlienType();
        else if(alien == null)
            nextAlien--;

        switch (lastMove) {
            case "Alien":
                direction = turn.choosePathAlien();
                switch (direction){
                    case "battle":
                        if(alien.battle()) {
                            addLog("Alien hit\n");
                            if (drone.damage())
                                return "Lost";
                        }
                        else
                            addLog("Alien miss\n");
                        break;
                    default:
                        alien.move(direction);
                        break;
                }
                lastMove = "Drone";
                break;
            case "Drone":
                direction = turn.choosePathDrone(drone.isHasResource());
                switch (direction) {
                    case "battle":
                        if (drone.battle()) {
                            addLog("Drone hit\n");
                            alien = null;
                            setNextAlien();
                        }
                        else
                            addLog("Drone Miss\n");
                        break;
                    case "getResource":
                        addLog("You got the resource");
                        drone.getResource();
                        break;
                    case "enterShip":
                        addLog("You reached the ship");
                        shipType.addCargo(planetType.getMinedResource(), sortAmountResource());
                        return "Won";
                    default:
                        drone.move(direction);
                        break;
                }
                if(alien != null)
                    lastMove = "Alien";
                break;
        }
        return "nextTurn";
    }
}
