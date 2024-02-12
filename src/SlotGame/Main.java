package SlotGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // Variables
        double bet = 0;
        int input = 0;
        boolean inGame = true;

        Scanner scn = new Scanner(System.in);

        //region Read house and jackpot data from the files
        File myObj = new File("jackpot.txt");
        Scanner rdScn = null;
        String dataJackpot = null;
        try {
            myObj.createNewFile();
            rdScn = new Scanner(myObj);
            while (rdScn.hasNextLine()) {
                dataJackpot = rdScn.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File houseObj = new File("house.txt");
        String dataHouse = null;
        try {
            houseObj.createNewFile();
            rdScn = new Scanner(houseObj);
            while (rdScn.hasNextLine()) {
                dataHouse = rdScn.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //endregion


        //region Initiate a slotMachine object
        // SlotMachineAdv alwaysWin = new SlotMachineAdv("TheWinner", 3);
        SlotMachine newGameMech = new SlotMachine("WinnersOnly",3, 0);
        if (dataJackpot != null) {
            newGameMech.setJackpot(Double.parseDouble(dataJackpot));
        }
        else {
            newGameMech.setJackpot(0);
        }
        if (dataHouse != null) {
            newGameMech.setHouse(Double.parseDouble(dataHouse));
        }
        else {
            SlotMachineAdv.setHouse(0);
        }
        //endregion

        //region Initiate a Player object
        System.out.println("Please enter your name");
        String name = scn.nextLine();
        System.out.println("Please enter your balance");
        double money = scn.nextDouble();
        Player Julienne = new Player(name, money);
        //endregion

        //region Menu
        while (inGame) {
            System.out.println("*******************SLOT GAME*******************");
            System.out.println("***********Welcome to the Slot Game!***********");
            System.out.println( "Your Balance:   " + Julienne.getMoney() + "$");
            System.out.printf(  "JACKPOT:        %.2f$\n", newGameMech.getJackpot());
            System.out.println("Please choose a number from the menu to start");
            System.out.println("1. Spin");
            System.out.println("2. Info");
            System.out.println("3. Exit");

            input = scn.nextInt();

            switch (input) {
                case 1:
                    // Check if player has enough amount to bet
                    if (bet >= Julienne.getMoney()){
                        System.out.println("You do not have enough money!");
                        break;
                    }

                    // stable bet maybe increasing bet can increase win chance
                    System.out.println("Please enter your bet");
                    bet = scn.nextDouble();
                    scn.nextLine();

                    // Deduct the bet amount from Player's account.
                    Julienne.setMoney(Julienne.getMoney() - bet);

                    // Spinning method
                    System.out.println(newGameMech.spinning());
                    newGameMech.calculations(bet,Julienne);

                    // End
                    bet = 0;
                    System.out.printf("Press enter to continue!\n");
                    scn.nextLine();
                    break;
                case 2:
                    // RTP is 96.04% with these ratios
                    System.out.println("Cherry Cherry Cherry                        --->    Jackpot");
                    System.out.println("Any four of Lemon, Orange, Bell or Plum     --->    x20");
                    System.out.println("Any two similar reels next to each other    --->    x1");
                    System.out.println("Press enter to continue!");
                    scn.nextLine();
                    scn.nextLine();
                    break;
                case 3:
                    System.out.println("Thank you for playing");

                    // Saving latest house and jackpot values to a file
                    try {
                        PrintWriter pw = new PrintWriter("jackpot.txt");
                        pw.write(Double.toString(newGameMech.getJackpot()));
                        pw.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        PrintWriter pw = new PrintWriter("house.txt");
                        pw.write(Double.toString(newGameMech.getHouse()));
                        pw.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    inGame = false;
                    break;
                case 5:
                    System.out.printf("House: %.2f$", SlotMachineAdv.getHouse());
                    break;
                default:
                    System.out.println("Please choose a number from the menu!");
                    break;
            }
        }
        //endregion

    }
}