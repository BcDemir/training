package SlotGame;

import java.util.ArrayList;
import java.util.Random;

public class SlotMachineAdv {

    String name;
    int reels, playCounterAfterJackpot;
    static double jackpot = 0, house = 0;

    /**
     *
     * @param name  name of the machine
     * @param reels number of reels max:3
     */
    public SlotMachineAdv(String name, int reels) {
        this.name = name;
        this.reels = reels;
    }

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
        // Amount goes to jackpot
        jackpot += money * .05f;    // adds 5% of the bet to the jackpot pool

        // Amount goes to house
        house += money * .95f;

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

        // assigning numbers to a variable for human-readable coding
        int nOne = listOfNumbers.get(0);
        int nTwo = listOfNumbers.get(1);
        int nThree = listOfNumbers.get(2);

        // Winning Checks
        // check for jackpot | probabilty .008
        if (nOne == 1 && nOne == nTwo && nTwo == nThree){
            Player.setMoney(Player.getMoney() + (jackpot));
            System.out.printf("JACKPOT!!! You won %.2f$", jackpot);
            SlotMachineAdv.setJackpot(0);   // set jackpot to zero
        }
        // check for other fruits same line win x20 bet | probabilty .032
        else if (nOne == nTwo && nTwo == nThree) {
            Player.setMoney(Player.getMoney() + (money * 20));
            System.out.printf("WOW!!! You won %.2f$", money * 20);
        }
        // check if two similar reels next to each other x1 bet | probabilty .32
        else if ((nOne == nTwo || nTwo == nThree) && nOne != nThree){
            Player.setMoney(Player.getMoney() + (money ));
            System.out.println("Free Spin");
        }

        System.out.println();
    }
}
