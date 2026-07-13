package model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private static Dice dice;

    public Dice(){

    }
    public static Dice getDice() {
        return dice == null ? new Dice() : dice;
    }
    public int roll(){
        return ThreadLocalRandom.current().nextInt(1,7);
    }

    
    
}
