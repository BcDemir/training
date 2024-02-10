package SlotGame;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Constructor creates a new SlotGame.SlotMachine object with a name, number of reels and jackpot variables
 */
public class SlotMachine {
    String name;
    int reels;
    double jackpot;

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
}
