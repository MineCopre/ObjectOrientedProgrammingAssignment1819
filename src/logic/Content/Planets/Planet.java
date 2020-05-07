package logic.Content.Planets;

import java.util.*;

public class Planet {

    private ArrayList<String> planetResources;
    private boolean spaceStation;
    private ArrayList<Integer> posResource;
    private String minedResource;

    public Planet(){

        posResource = new ArrayList<Integer>();
        planetResources = new ArrayList<>();
        Random rand = new Random();
        if(rand.nextInt(10)>6)
            spaceStation = true;
        else
            spaceStation = false;

    }

    public void addResources(String type){
        planetResources.add(type);
    }

    public boolean isSpaceStation() {return spaceStation; }

    @Override
    public String toString(){
        String aux = new String();
        if(spaceStation)
            aux += "This Planet has a SpaceStation \n";
        return aux;
    }

    public String sortPlanetResource(){

        Random rand = new Random();
        minedResource = planetResources.get(rand.nextInt(2));
        return minedResource;
    }

    public String getMinedResource(){
        return minedResource;
    }

    public ArrayList<Integer> getPosResource() {
        return posResource;
    }

    public void setPosResource() {

        Random rand = new Random();

        posResource.add(rand.nextInt(6));
        posResource.add(rand.nextInt(6));
    }
}
