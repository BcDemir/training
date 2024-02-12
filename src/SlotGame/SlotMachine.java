package SlotGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Constructor creates a new SlotGame.SlotMachine object with a name, number of reels and jackpot variables
 */
public class SlotMachine {
    private String name;
    private int reels = 3;
    private double jackpot, house;

    public SlotMachine(String name, int reels, double jackpot) {
        this.name = name;
        this.reels = reels;
        this.jackpot = jackpot;
    }

    public SlotMachine() {
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

    public double getJackpot() {
        return jackpot;
    }

    public void setJackpot(double jackpot) {
        this.jackpot = jackpot;
    }

    public double getHouse() {
        return house;
    }

    public void setHouse(double house) {
        this.house = house;
    }

    // create an array to hold all the numbers and Strings
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<String> listOfFruits = new ArrayList<>();

    public String spinning(){
        for (int i = 0; i < this.reels; i++){
            Random rnd = new Random();
            int random = rnd.nextInt(5);
            numbers.add(random);

            switch (++random){
                case 1:
                    listOfFruits.add("Cherry");
                    break;
                case 2:
                    listOfFruits.add("Lemon");
                    break;
                case 3:
                    listOfFruits.add("Orange");
                    break;
                case 4:
                    listOfFruits.add("Plum");
                    break;
                case 5:
                    listOfFruits.add("Bell");
                    break;
                default:
                    System.out.printf("There is a problem!");
            }
        }
        String output = listOfFruits.get(0) + " " + listOfFruits.get(1) + " " + listOfFruits.get(2);
        listOfFruits.clear();
        return output;
    }

    /**
     *
     * @param money     amount that a player bets
     * @param Player    player object who is playing the game
     */
    public void calculations(double money, Player Player){
        // Amount goes to jackpot
        jackpot += money * .05f;    // adds 5% of the bet to the jackpot pool

        // Amount goes to house
        house += money * .95f;

        // assigning numbers to a variable for human-readable coding
        int nOne = numbers.get(0);
        int nTwo = numbers.get(1);
        int nThree = numbers.get(2);

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
            Player.setMoney(Player.getMoney() + money);
            System.out.println("Free Spin");
        }

        System.out.println();
        this.numbers.clear();
    }
}
