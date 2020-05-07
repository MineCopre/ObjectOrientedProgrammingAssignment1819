package logic.Content.Planets;

public class blackPlanet extends Planet{

    public blackPlanet(){

        super();
        addResources("Black");
        addResources("Blue");

    }

    @Override
    public String toString(){
        String aux = new String();

        aux += "Black Planet \n";
        aux += "This planet resources are: Black and Blue resources \n";
        aux += super.toString();
        return aux;
    }

}
