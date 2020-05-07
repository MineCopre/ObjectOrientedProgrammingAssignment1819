package logic.Content.SurfaceMining;

import Data.*;

import java.util.ArrayList;

public class battleTurn {

    private gameData gameInfo;
    private double distDroneAlien;
    private double distDroneResource;
    private double distDroneShip;
    private ArrayList<Integer> vetDistDroneAlien;
    private ArrayList<Integer> vetDistDroneResource;
    private ArrayList<Integer> vetDistDroneShip;

    public battleTurn(gameData gameInfo){

        this.gameInfo = gameInfo;

        vetDistDroneAlien = new ArrayList<Integer>(vetDist(gameInfo.getDrone().getPosDrone(), gameInfo.getAlien().getPosAlien()));
        vetDistDroneShip = new ArrayList<Integer>(vetDist(gameInfo.getDrone().getPosDrone(), gameInfo.getShipType().getPosShip()));
        vetDistDroneResource = new ArrayList<Integer>(vetDist(gameInfo.getDrone().getPosDrone(), gameInfo.getPlanetType().getPosResource()));
        distDroneAlien = measureDist(vetDistDroneAlien);
        distDroneShip = measureDist(vetDistDroneShip);
        distDroneResource = measureDist(vetDistDroneResource);
    }

    public double measureDist(ArrayList<Integer> dist){

        return Math.sqrt(Math.pow((double)(dist.get(0)),2) + Math.pow((double)dist.get(1),2));
    }

    public ArrayList<Integer> vetDist(ArrayList<Integer> drone, ArrayList<Integer> object){

        ArrayList aux = new ArrayList();

        aux.add(drone.get(0)-object.get(0));
        aux.add(drone.get(1)-object.get(1));

        return aux;
    }

    public String choosePathAlien(){

        if(distDroneAlien > Math.sqrt(2))
        {
            if(Math.pow(vetDistDroneAlien.get(0),2) > Math.pow(vetDistDroneAlien.get(1),2))
            {
                if(vetDistDroneAlien.get(0) > 0)
                    return "moveRight";
                else
                    return "moveLeft";
            }
            else {
                if (vetDistDroneAlien.get(1) < 0)
                    return "moveUp";
                else
                    return "moveDown";
            }
        }
        return "battle";
    }

    public String choosePathDrone(boolean hasResource){

        if(distDroneAlien > Math.sqrt(2))
        {
            if(!hasResource) {
                if (distDroneResource > Math.sqrt(2)) {
                    if (Math.pow(vetDistDroneResource.get(0), 2) > Math.pow(vetDistDroneResource.get(1), 2)) {
                        if (vetDistDroneResource.get(0) > 0)
                            return "moveLeft";
                        else
                            return "moveRight";
                    } else {
                        if (vetDistDroneResource.get(1) < 0)
                            return "moveDown";
                        else
                            return "moveUp";
                    }
                } else
                    return "getResource";
            }else {
                if (distDroneShip > Math.sqrt(2)) {
                    if (Math.pow(vetDistDroneShip.get(0), 2) > Math.pow(vetDistDroneShip.get(1), 2)) {
                        if (vetDistDroneShip.get(0) > 0)
                            return "moveLeft";
                        else
                            return "moveRight";
                    } else {
                        if (vetDistDroneShip.get(1) > 0)
                            return "moveDown";
                        else
                            return "moveUp";
                    }
                } else
                    return "enterShip";
            }
        }
        else
            return "battle";
    }


}
