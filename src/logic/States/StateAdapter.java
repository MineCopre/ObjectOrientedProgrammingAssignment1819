package logic.States;

import Data.*;

public abstract class StateAdapter implements IStates {

    protected gameData gameInfo;

    public StateAdapter(gameData g){ gameInfo = g; }

    public gameData getGameInfo() {return gameInfo; }

    public void setGameInfo(gameData gameInfo) {
        this.gameInfo = gameInfo;
    }

    //IStates methods
    public IStates shipSelection(int ship){return this;}

    public IStates firstMove(){return this;}

    public IStates moveShip() {return this;}

    public IStates minePlanet(String turnEvent) {return this;}

    public IStates enterPlanet() {return this;}

}
