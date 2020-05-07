package logic.Content.Planets;

public class redPlanet extends Planet {

    public redPlanet() {

        super();
        addResources("Red");
        addResources("Blue");

    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Red Planet \n";
        aux += "This planet resources are: Red and Blue resources \n";
        aux += super.toString();
        return aux;
    }
}
