package logic.Content.SurfaceMining;

import java.util.ArrayList;
import java.util.Random;

public class Alien {

    private ArrayList<Integer> posAlien;
    private String alienType;

    public Alien(){

        posAlien = new ArrayList<Integer>();

        Random rand = new Random();

        switch (rand.nextInt(4))
        {
            case 0:
                alienType = "Blue";
                break;
            case 1:
                alienType = "Green";
                break;
            case 2:
                alienType = "Black";
                break;
            case 3:
                alienType = "Red";
                break;
        }

    }


    public String getAlienType() {
        return alienType;
    }

    public ArrayList<Integer> getPosAlien() {
        return posAlien;
    }

    public void setPosAlien() {

        Random rand = new Random();

        posAlien.add(rand.nextInt(6));
        posAlien.add(rand.nextInt(6));

    }

    public boolean battle(){

        Random rand = new Random();

        if(alienType == "Black") {
            if(rand.nextInt(6) < 1)
                return true;
            return false;
        }
        else {
            if(rand.nextInt(6) < 2)
                return true;
            return false;
        }
    }

    public void move(String action){

        switch (action) {
            case "moveUp":
                posAlien.set(1, posAlien.get(1) - 1);
                break;
            case "moveDown":
                posAlien.set(1, posAlien.get(1) + 1);
                break;
            case "moveLeft":
                posAlien.set(0, posAlien.get(0) - 1);
                break;
            case "moveRight":
                posAlien.set(0, posAlien.get(0) + 1);
                break;
        }
    }
}
