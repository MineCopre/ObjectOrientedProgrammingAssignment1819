package logic.Content.Ships;

public class miningShip extends Ship {

    public miningShip() {

        super();
        setShields(18);
        setFuel(45);
        setWeapons(9);

    }

    @Override
    public void upgradeCargo(){
        switch (getMaxCargoCapacity()) {
            case 6:
                setMaxCargoCapacity(12);
                break;
            case 12:
                setMaxCargoCapacity(18);
                break;
            case 18:
                setMaxCargoCapacity(24);
                break;
            default:
                setMaxCargoCapacity(6);
                break;
        }
    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Mining Ship\n";
        aux += super.toString();

        return aux;
    }

}
