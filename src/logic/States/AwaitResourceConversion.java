package logic.States;

import Data.gameData;

public class AwaitResourceConversion extends StateAdapter{

    public AwaitResourceConversion(gameData g){
        super(g);
    }

    public IStates convertResources(gameData g){
        return new AwaitResourceConversion(g);
    }

    public IStates mineSurface(gameData g){
        return new AwaitMining(g);
    }

    public IStates returnToOrbit(gameData g){
        return new AwaitMove(g);
    }

}
