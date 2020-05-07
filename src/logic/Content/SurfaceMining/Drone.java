package logic.Content.SurfaceMining;

import java.util.ArrayList;
import java.util.Random;

public class Drone {

    private ArrayList<Integer> posDrone;
    private boolean hasResource;
    private int health;

    public Drone(ArrayList<Integer> posNave){

        health = 6;
        hasResource = false;
        posDrone = new ArrayList<Integer>(posNave);

    }

    public ArrayList<Integer> getPosDrone() {
        return posDrone;
    }

    public boolean isHasResource() {
        return hasResource;
    }

    public void getResource(){
        hasResource = true;
    }

    public boolean battle(){

        Random rand = new Random();

        if(rand.nextInt(6) < 2)
            return true;
        return false;
    }

    public boolean damage(){
        health--;
        if(health == 0)
            return true;
        return false;
    }

    public void move(String action){

        switch (action) {
            case "moveUp":
                posDrone.set(1, posDrone.get(1) - 1);
                break;
            case "moveDown":
                posDrone.set(1, posDrone.get(1) + 1);
                break;
            case "moveLeft":
                posDrone.set(0, posDrone.get(0) - 1);
                break;
            case "moveRight":
                posDrone.set(0, posDrone.get(0) + 1);
                break;
        }
    }
}
