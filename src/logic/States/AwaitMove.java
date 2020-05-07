package logic.States;

import Data.gameData;
import logic.Content.Planets.*;
import java.util.*;

import logic.Content.Ships.Events;
import logic.Exception.*;

public class AwaitMove extends StateAdapter {

    public AwaitMove(gameData g) {
        super(g);
    }

    @Override
    public IStates firstMove(){

        Random rand = new Random();
        int planetType;
        planetType = rand.nextInt(4);

        switch (planetType){
            case 0:
                gameInfo.setPlanetType(new redPlanet());
                break;
            case 1:
                gameInfo.setPlanetType(new blackPlanet());
                break;
            case 2:
                gameInfo.setPlanetType(new bluePlanet());
                break;
            case 3:
                gameInfo.setPlanetType(new greenPlanet());
                break;
        }
        gameInfo.addLog("This is a " + gameInfo.getPlanetType().toString());
        return this;
    }

    @Override
    public IStates moveShip(){
        Random rand = new Random();

        try {
            if (rand.nextInt(8) < 1)
                gameInfo.moveWormhole();
            else {
                gameInfo.move();
                new Events(rand.nextInt(7), gameInfo);
                gameInfo.move();
            }

            switch (rand.nextInt(4)) {
                case 0:
                    gameInfo.setPlanetType(new redPlanet());
                    break;
                case 1:
                    gameInfo.setPlanetType(new blackPlanet());
                    break;
                case 2:
                    gameInfo.setPlanetType(new bluePlanet());
                    break;
                case 3:
                    gameInfo.setPlanetType(new greenPlanet());
                    break;
            }
        }
        catch (noFuelException e){
            gameInfo.addLog(e.toString());
            return new AwaitShipSelection(gameInfo);
        }
        catch (noCrewRemaining e){
            gameInfo.addLog(e.toString());
            return new AwaitShipSelection(gameInfo);
        }

        gameInfo.addLog("This is a " + gameInfo.getPlanetType().toString());
        gameInfo.addLog(gameInfo.getShipType().toString());
        return new AwaitMove(gameInfo);
    }

    @Override
    public IStates enterPlanet() {

        gameInfo.addLog("You entered a " + gameInfo.getPlanetType().toString());
        gameInfo.sortPlanetResource();
        gameInfo.sortAlienType();
        gameInfo.sortLocations();
        return new AwaitMining(gameInfo);

    }

}
