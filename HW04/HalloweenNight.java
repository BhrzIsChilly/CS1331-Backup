/*
* Braiden Anderson
* CS 1331  --  10/22/2024
* HalloweenNight.java
*/

/**
 * This class does crap
 */


public class HalloweenNight {
    // Variables
    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;
    private int arraysLength;


    // Constructors
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
        this.arraysLength = this.cryptKickerFive.length; // both arrays equals the same length
    }


    // Methods
    public String toString() {
        String returnString = "cryptKickerFive: ";

        for (int i = 0; i < arraysLength; i++) {
            if (i != 0)
                returnString += ", ";
            returnString += String.format("%s", this.cryptKickerFive[i].toString());
            System.out.println(returnString); // %debug
        }
        returnString += " versus ghoulGang: ";

        for (int i = 0; i < arraysLength; i++) {
            if (i != 0)
                returnString += ", ";
            returnString += String.format("%s", this.ghoulGang[i].toString());
            System.out.println(returnString); // %debug
        }

        return returnString;
    }

    private void compareTeams() {
        int favorScore = 0;

        for (int i = 0; i < arraysLength; i++) {
            favorScore += cryptKickerFive[i].compareTo(ghoulGang[i]);
        }

        if (favorScore > 0) {
            System.out.println("crypticKickerFive is favored.");
        }
        
        if (favorScore < 0) {
            System.out.println("ghoulGang is favored.");
        }

        if (favorScore == 0) {
            System.out.println("Neither team is favored.");
        }
    }

    public void battle(int winningCandyThreshhold) {
        int winThreshhold = winningCandyThreshhold;
        int ghoulCandies = 0;
        int crypticCandies = 0;

        if (winThreshhold < 0) {
            int winThreshhold = 60; //Default value
        }
        
        Ghost temporary = new Ghost();

        while (ghoulCandies < 60 || crypticCandies < 60) {
            for (int i = 0; i < arraysLength; i++) {
                this.crypticKickerFive[i].trickOrTreat();
                if (this.crypticKickerFive[i].getClass().equals(temporary)) {
                    this.crypticKickerFive[i].rob(this.ghoulGang[i]);
                }
            }
        }

    }
}