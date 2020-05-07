package logic.States;

import Data.gameData;

public class AwaitMining extends StateAdapter {

    public AwaitMining(gameData g){
        super(g);
    }

    public IStates convertResources(gameData g){
        return new AwaitResourceConversion(g);
    }

    @Override
    public IStates minePlanet(String turnEvent) {

        switch (turnEvent) {
            default:
                return new AwaitMining(gameInfo);
            case "Won":
                return new AwaitResourceConversion(gameInfo);
            case "Lost":
                return new AwaitMove(gameInfo);
        }
    }
}
