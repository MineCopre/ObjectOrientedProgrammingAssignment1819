package logic.Content.Ships;

public class militaryShip extends Ship {

    public militaryShip() {

        super();
        setShields(9);
        setFuel(27);
        setWeapons(18);

    }

    @Override
    public void upgradeCargo(){
        if(getMaxCargoCapacity() < 12)
            setMaxCargoCapacity(12);
    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Military Ship\n";
        aux += super.toString();

        return aux;
    }

}
