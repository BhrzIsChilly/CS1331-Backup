/*
* Braiden Anderson
* CS 1331  --  10/22/2024
* HalloweenNight.java
*/

package yum; // %debug

public class HalloweenNight {
    // Variables
    TrickOrTreater[] cryptKickerFive;
    TrickOrTreater[] ghoulGang;


    // Constructors
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
    }

    public String toString() {
        String returnString = "cryptKickerFive: ";

        for (int i = 0; i < this.cryptKickerFive.length; i++) {
            if (i != 0)
                returnString += ", ";
            returnString += String.format("%s", this.cryptKickerFive[i].toString());
            System.out.println(returnString); // %debug
        }
        returnString += " versus ghoulGang: ";

        for (int i = 0; i < this.ghoulGang.length; i++) {
            if (i != 0)
                returnString += ", ";
            returnString += String.format("%s", this.ghoulGang[i].toString());
            System.out.println(returnString); // %debug
        }

        return returnString;
    }
}