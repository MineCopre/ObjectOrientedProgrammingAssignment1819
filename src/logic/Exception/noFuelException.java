package logic.Exception;

public class noFuelException extends Exception{

    public noFuelException(){
    }

    @Override
    public String toString(){
        return "Ship has no fuel";
    }
}
