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

        // Read house and jackpot data from the files
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


        // Initiate a slotMachine object
        SlotMachineAdv alwaysWin = new SlotMachineAdv("TheWinner", 3);
        if (dataJackpot != null) {
            SlotMachineAdv.setJackpot(Double.parseDouble(dataJackpot));
        }
        else {
            SlotMachineAdv.setJackpot(0);
        }
        if (dataHouse != null) {
            SlotMachineAdv.setHouse(Double.parseDouble(dataHouse));
        }
        else {
            SlotMachineAdv.setHouse(0);
        }

        // Initiate a Player object
        System.out.println("Please enter your name");
        String name = scn.nextLine();
        System.out.println("Please enter your balance");
        double money = scn.nextDouble();
        Player Julienne = new Player(name, money);


        // Menu
        while (inGame) {
            System.out.println("*******************SLOT GAME*******************");
            System.out.println("**********Welcome to the Slots Game!***********");
            System.out.println("Your Balance: " + Julienne.getMoney() + "$");
            System.out.println("Jackpot     : " + SlotMachineAdv.jackpot + "$");
            System.out.println("Please choose a number from the menu to start");
            System.out.println("1. Play");
            System.out.println("2. Exit");

            input = scn.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Please enter your bet");
                    bet = scn.nextDouble();
                    scn.nextLine();

                    // Deduct the bet amount from Player's account. Here should be a validation
                    // for account balance to prevent dropping below 0
                    Julienne.setMoney(Julienne.money - bet);

                    // Spinning method
                    alwaysWin.spinning(bet, Julienne);

                    // End
                    System.out.printf("Press enter to continue!\n");
                    scn.nextLine();
                    break;
                case 2:
                    System.out.println("Thank you for playing");

                    // Saving latest house and jackpot values to a file
                    try {
                        PrintWriter pw = new PrintWriter("jackpot.txt");
                        pw.write(Double.toString(SlotMachineAdv.getJackpot()));
                        pw.close();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        PrintWriter pw = new PrintWriter("house.txt");
                        pw.write(Double.toString(SlotMachineAdv.getHouse()));
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



        /*
        insan ve inherite eden classlar olustur. bunlar oyuncular olsun
        hepsinin parasi olsun initiate ederken. while dongulu bir menu olsun
        oyun oynayan bet koyup oynasin bu sirada jackpot biriksin. kaybetme counter i arttikca
        jackpot kazanma olasiligi artsin. house kazanci sayaci olsun onu menude gizli bir sayiya basrak gorebilelim
         */

    }
}