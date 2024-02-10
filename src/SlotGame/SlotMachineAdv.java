package SlotGame;

import java.util.ArrayList;
import java.util.Random;

public class SlotMachineAdv {

    String name;
    int reels, playCounterAfterJackpot;
    static double jackpot = 0, house = 0;
    boolean isJackpot = false;

    public SlotMachineAdv(String name, int reels) {
        this.name = name;
        this.reels = reels;
    }

    /**
     *
     * @param name  name of the machine
     * @param reels number of reels, max:5
     */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReels() {
        return reels;
    }

    public void setReels(int reels) {
        this.reels = reels;
    }

    public static double getJackpot() {
        return jackpot;
    }

    public static void setJackpot(double jackpot) {
        SlotMachineAdv.jackpot = jackpot;
    }

    public static double getHouse() {
        return house;
    }

    public static void setHouse(double house) {
        SlotMachineAdv.house = house;
    }

    /**
     *
     * @param money     amount that a player bets
     * @param Player    player object who is playing the game
     */
    public void spinning(double money, Player Player){

        // Amount of the money played to the jackpot
        jackpot += (money * .25f);
        house += (money * .75f);

        // create an array to hold all the numbers
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

        // For loop to generate random number for #reels times
        for (int i = 0; i < this.reels; i++){
            Random rnd = new Random();
            int random = rnd.nextInt(5);

            switch (++random){
                case 1:
                    System.out.printf("Cherry  ");
                    break;
                case 2:
                    System.out.printf("Lemon  ");
                    break;
                case 3:
                    System.out.printf("Orange  ");
                    break;
                case 4:
                    System.out.printf("Plum  ");
                    break;
                case 5:
                    System.out.printf("Bell  ");
                    break;
                default:
                    System.out.printf("There is a problem!");

            }

            listOfNumbers.add(random);

        }

        // For loop to check for jackpot and change isJackpot flag
        for(int j = 0; j < listOfNumbers.size() - 1; j++){
            if(listOfNumbers.get(j).intValue() != listOfNumbers.get(j+1).intValue()){
                this.isJackpot = false;
                System.out.println();
                System.out.println("Better luck next time!");
                break;
            }
            else {
                this.isJackpot = true;
            }
        }

        // If hit the jackpot, player balance will be updated here and jackpot will set to zero
        if(this.isJackpot){
            System.out.printf("\n***** CONGRATS!!! YOU HIT THE JACKPOT! *****\n");
            Player.setMoney(Player.getMoney() + jackpot);
            jackpot = 0;
            Player.winCheer("Yeahhhh");
            isJackpot = false;
        }

        System.out.println();
    }
}
