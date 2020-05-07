package UI;

import logic.*;
import logic.States.*;

import java.util.*;

public class gameUI {

    private PlanetBound game;
    private boolean quit = false;
    private Scanner sc = new Scanner(System.in);


    public gameUI(PlanetBound game){
        this.game = game;
    }

    public void uiAwaitShipSelection(){

        int op;

        System.out.println("Welcome to PlanetBound");
        System.out.println("Pick your ship");
        System.out.println("1 - Military Ship");
        System.out.println("2 - Mining Ship");

        op = sc.nextInt();

        do {
            switch (op) {
                case 1:
                    System.out.println("You choosed the military ship");
                    game.chooseShip(1);
                    game.firstMove();
                    break;
                case 2:
                    System.out.println("You choosed the mining ship");
                    game.chooseShip(2);
                    game.firstMove();
                    break;
                default:
                    System.out.println("Choose either 1 or 2");
            }
        }while(op >= 3);

    }

    public void uiAwaitMining(){

        do {
            if (game.getGamedata().checkLogs()) {
                for (String msg : game.getGamedata().getLogs())
                    System.out.println(msg);
            }

            game.getGamedata().clearLogs();

            System.out.println("1 - to continue");
            sc.nextInt();
        }while(game.minePlanet());
    }

    public void uiAwaitMove(){

        int op;

        if(game.getGamedata().checkLogs()) {
            for (String msg : game.getGamedata().getLogs())
                System.out.println(msg);
        }

        game.getGamedata().clearLogs();

        System.out.println("What do you want to do next?");
        System.out.println("1 - Move to next planet");
        System.out.println("2 - Enter Planet");
        if(game.getPlanet().isSpaceStation())
            System.out.println("3 - Enter SpaceStation");

        op = sc.nextInt();

        do {
            switch (op) {
                case 1:
                    System.out.println("Moving to the next planet");
                    game.moveShip();
                    break;
                case 2:
                    System.out.println("Entering Planet");
                    game.enterPlanet();
                    break;
                default:
                    System.out.println("Choose either 1,2 or 3");
            }
        }while(op >= 4);
    }

    public void uiAwaitResourceConversion(){

    }

    public void uiAwaitBuyDecision(){}

    public void run(){

        while(!quit)
        {
            IStates state = game.getState();

            if(state instanceof AwaitShipSelection)
                uiAwaitShipSelection();
            else if(state instanceof AwaitBuyDecision)
                uiAwaitBuyDecision();
            else if(state instanceof AwaitMove)
                uiAwaitMove();
            else if(state instanceof AwaitMining)
                uiAwaitMining();
            else if(state instanceof AwaitResourceConversion)
                uiAwaitResourceConversion();
        }
    }
}
