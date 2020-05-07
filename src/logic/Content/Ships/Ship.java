package logic.Content.Ships;

import java.util.*;
import logic.Exception.*;

public class Ship {

    private int shields;
    private int weapons;
    private int fuel;
    private int maxCargoCapacity;
    private HashMap<String, Integer> resources;
    private shipCrew crew;
    private ArrayList<Integer> posShip;

    public Ship() {

        posShip = new ArrayList<Integer>();
        resources =  new HashMap<String, Integer>();
        resources.put("Blue", 0);
        resources.put("Red", 0);
        resources.put("Green", 0);
        resources.put("Black", 0);
        maxCargoCapacity = 6;
        crew = shipCrew.CARGO;

    }

    public void removeCargo(String type, int cargo)
    {
        if(resources.get(type) <= 0)
            resources.put(type, 0);
        else
            resources.put(type, resources.get(type)-cargo);
    }

    public void addCargo(String type, int cargo){
        if(resources.get(type) + cargo >= getMaxCargoCapacity())
            resources.put(type,getMaxCargoCapacity());
        else
            resources.put(type,resources.get(type) + cargo);
    }

    public void upgradeCargo() { }

    public void addCrew(){
        switch (crew){
            case CARGO:
                break;
            case WEAPONS:
                crew = shipCrew.CARGO;
                break;
            case SHIELDS:
                crew = shipCrew.WEAPONS;
                break;
            case LANDING:
                crew = shipCrew.SHIELDS;
                break;
            case NAVIGATION:
                crew = shipCrew.CAPTAIN;
                break;
            case CAPTAIN:
                crew = shipCrew.NAVIGATION;
                break;
        }
    }

    public void useFuel(int amount) throws noFuelException{
        if(fuel >= amount)
            fuel = fuel - amount;
        else
            throw new noFuelException();
    }

    public void move() throws noFuelException{
        useFuel(1);
    }

    public void moveWormhole() throws noFuelException, noCrewRemaining{
        if(shields >= 3 && fuel >= 3)
        {
            shields = shields - 2;
            useFuel(3);
        }
        else if(shields < 3)
            crewDeath();
        else if(crew == shipCrew.LANDING)
        {
            useFuel(4);
            shields = shields - 4;
        }
    }

    public void crewDeath() throws noCrewRemaining{
        switch (crew){
            case CARGO:
                crew = shipCrew.WEAPONS;
                break;
            case WEAPONS:
                crew = shipCrew.SHIELDS;
                break;
            case SHIELDS:
                crew = shipCrew.LANDING;
                break;
            case LANDING:
                crew = shipCrew.NAVIGATION;
                break;
            case NAVIGATION:
                crew = shipCrew.CAPTAIN;
                break;
            case CAPTAIN:
                throw new noCrewRemaining();
        }
    }

    public int getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public void setMaxCargoCapacity(int maxCargoCapacity) {
        this.maxCargoCapacity = maxCargoCapacity;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Fuel: " + fuel + "\n";
        aux += "Weapons: " + weapons + "\n";
        aux += "Shields: " + shields + "\n";
        aux += "Max Cargo: " + maxCargoCapacity + "\n";
        aux += "Blue Resource: " + resources.get("Blue") + "\n";
        aux += "Red Resource: " + resources.get("Red") + "\n";
        aux += "Black Resource: " + resources.get("Black") + "\n";
        aux += "Green Resource: " + resources.get("Green") + "\n";
        return aux;
    }

    public ArrayList<Integer> getPosShip() {
        return posShip;
    }

    public void setPosShip() {

        Random rand = new Random();

        posShip.add(rand.nextInt(6));
        posShip.add(rand.nextInt(6));
    }
}

