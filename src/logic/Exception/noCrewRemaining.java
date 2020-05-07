package logic.Exception;

public class noCrewRemaining extends Exception {

    public noCrewRemaining(){

    }

    @Override
    public String toString(){
        return "You lost all crew;";
    }

}
