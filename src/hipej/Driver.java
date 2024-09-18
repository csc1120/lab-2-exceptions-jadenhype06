/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Jaden
 * Last Updated: Hipe
 */
package hipej;

import java.util.Scanner;

/**
 * Driver class
 */
public class Driver {
    /**
     * Minimum dice
     */
    public static int MIN_DICE = 2;
    /**
     * Max dice
     */
    public static int MAX_DICE = 10;
    public static void main(String[] args) {
        int[] list;
        list = getInput();
        int[] rolled = rollDice(createDice(list[0], list[1]), list[1], list[2]);
        int max = findMax(rolled);
        report(list[0], rolled, max);

    }

    /**
     * Finds highest number of values rolled,
     * @param rolls array of rolls
     * @return most common value
     */
    public static int findMax(int[] rolls) {
        int max = 0;
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }

    /**
     * gets input from user
     * @return split String into integers
     */
    public static int[] getInput() {
        boolean validinput = false;
        int[] y = new int[3];
        while(!validinput) {
            Scanner scan = new Scanner(System.in);
            String x = scan.nextLine();

            int start = 0;
            int count = 0;
            for (int i = 0; i <= x.length(); i++) {
                if (i == x.length() || x.charAt(i) == ' ') {
                    try {
                        y[count] = Integer.parseInt(x.substring(start, i));
                        start = i + 1;
                        count++;

                    } catch (StringIndexOutOfBoundsException e) {
                        System.err.println("Invalid input");

                    } catch (NumberFormatException e) {
                        System.err.println("All values must be whole numbers");

                    }
                }
                validinput = true;
            }
        }
        if (y[0] > MAX_DICE || y[0] < MIN_DICE) {
            System.out.println("Invalid Input");
        }
        return y;
    }

    /**
     * initializes the dice and puts them in a list
     * @param numDice number of dice
     * @param numSides number of sides on dice
     * @return array of dice
     */
    public static Die[] createDice(int numDice, int numSides) {
        Die[] Dice = new Die[numDice];
        for (int i = 0; i < Dice.length; i++) {
            Dice[i] = new Die(numSides);
        }
        return Dice;
    }

    /**
     * Rolls the dice
     * @param dice array of dice
     * @param numSides number of sides on dice
     * @param numRolls number of rolls that will occur
     * @return array of stats
     */
    public static int[] rollDice(Die[] dice, int numSides, int numRolls) {
        int[] all = new int[numRolls];
        int[] possible = new int[(dice.length * numSides) - dice.length + 1];
        int[] result = new int[(dice.length * numSides) - dice.length + 1];
        int count = 0;
        int count2 = 0;
        for (int k = dice.length; k <= (dice.length * numSides); k++) {
            possible[count] = k;
            count++;
        }
        for (int i = 1; i <= numRolls; i++) {
            int total = 0;
            for (Die die : dice) { //dice.length is the amount of dice
                die.roll();
                total += die.getCurrentValue();

            }
            all[count2] = total;
            count2++;
        }
        for (int res : all) {
            for (int m = 0; m < possible.length; m++) {
                if (res == possible[m]) {
                    result[m]++;
                }
            }
        }
        return result;
    }


    /**
     * graphs the dice stats
     * @param numDice number of dice
     * @param rolls array of stats of rolled dice
     * @param max highest stat
     */
    public static void report(int numDice, int[] rolls, int max) {
        int scale = max / 10;
        int count = 0;
        for (int roll : rolls) {
            int numStars = roll / scale;
            String stars = "";

            for (int j = 0; j < numStars; j++) {
                stars += "*";
            }

            int data = numDice + count;
            count++;
            System.out.printf("%d :"+ roll +" \t%s", data, stars);
            System.out.println();
        }
    }
}