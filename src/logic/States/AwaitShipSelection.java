package logic.States;

import Data.*;
import logic.Content.Ships.militaryShip;
import logic.Content.Ships.miningShip;

public class AwaitShipSelection extends StateAdapter {

    public AwaitShipSelection(gameData g){
        super(g);
    };

    @Override
    public IStates shipSelection(int ship){
        if(ship == 1)
            gameInfo.setShipType(new militaryShip());
        else
            gameInfo.setShipType(new miningShip());
        return new AwaitMove(gameInfo);
    }
}

