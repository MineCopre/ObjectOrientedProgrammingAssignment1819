package logic.Content.Planets;

public class greenPlanet extends Planet{

    public greenPlanet(){

        super();
        addResources("Red");
        addResources("Green");

    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Green Planet \n";
        aux += "This planet resources are: Red and Green resources \n";
        aux += super.toString();
        return aux;
    }
}
