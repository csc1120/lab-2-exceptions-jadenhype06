/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Jaden Hipe
 * Last Updated: 9/16/2024
 */
package hipej;

import java.util.Random;

public class Die{
    public static int MIN_SIDES = 2;
    public static int MAX_SIDES = 100;
    private int currentValue = 0;
    private final int numSides;
    private final Random random = new Random();

    public Die(int numSides) {
        this.numSides = numSides;
        if (!(numSides <= 100 && numSides >= 2)) {
            throw new IllegalArgumentException();
        }

    }
    public int getCurrentValue(){
        if (currentValue < 1 || currentValue > numSides)
            throw new DieNotRolledException();
        int CurrentValue = currentValue;
        currentValue = 0;
        return CurrentValue;
    }
    public void roll() {
        currentValue = random.nextInt(1, numSides + 1);
    }

}