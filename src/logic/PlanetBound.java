package logic;

import Data.*;
import logic.States.AwaitMove;
import logic.States.AwaitShipSelection;
import logic.States.IStates;
import logic.Content.Planets.*;

import java.util.Random;

public class PlanetBound {

    private  gameData gamedata ;
    private IStates state;

    public PlanetBound(){
        gamedata = new gameData();
        state =  new AwaitShipSelection(gamedata);
    }

    public gameData getGamedata() {
        return gamedata;
    }

    public void setGamedata(gameData gamedata) {
        this.gamedata = gamedata;
    }

    public IStates getState() {
        return state;
    }

    public void setState(IStates state) {
        this.state = state;
    }

    public void chooseShip(int ship){
        state = state.shipSelection(ship);
    }

    public void firstMove(){
        state = state.firstMove();
    }

    public void enterPlanet(){
        state = state.enterPlanet();
        gamedata.drawBoard();
    }

    public boolean minePlanet(){
        state = state.minePlanet(gamedata.nextTurn());

        gamedata.drawBoard();

        if(state instanceof AwaitMove) return true;

        return false;
    }

    public Planet getPlanet()
    {
        return gamedata.getPlanetType();
    }

    public void moveShip()
    {
        state = state.moveShip();
    }

}
