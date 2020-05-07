package logic.States;

public interface IStates {

    public IStates shipSelection(int ship);
    public IStates firstMove();
    public IStates moveShip();
    public IStates minePlanet(String turnEvent);
    public IStates enterPlanet();
}
