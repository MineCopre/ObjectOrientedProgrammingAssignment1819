package logic.States;

import Data.*;

public class AwaitBuyDecision extends StateAdapter {

    public AwaitBuyDecision(gameData gameInfo){
        super(gameInfo);
    }

    public IStates leaveStation(gameData gameInfo) {
        return new AwaitMove(gameInfo);
    }

}
