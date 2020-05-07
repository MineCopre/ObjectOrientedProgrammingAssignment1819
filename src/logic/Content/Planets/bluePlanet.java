package logic.Content.Planets;

public class bluePlanet extends Planet{

    public bluePlanet(){
        super();
        addResources("Black");
        addResources("Green");
        addResources("Red");
        addResources("Blue");
    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Blue Planet \n";
        aux += "This planet resources are: Black, Blue, Green and Red resources \n";
        aux += super.toString();
        return aux;
    }

}
