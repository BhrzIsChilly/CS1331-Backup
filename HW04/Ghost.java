/*
* Braiden Anderson
* CS 1331  --  10/22/2024
* Ghost.java
*/

package yum; // %debug


public class Ghost extends TrickOrTreater{
    // Variables
    private int robberiesConducted;


    // Default Variables
    private static final String DEF_NAME = "Casper the Unfriendly Ghost"; 
    private static final int DEF_AGE = 12;
    private static final int DEF_NUM_CANDY = 0;
    private static final int DEF_ROBBERIES_CONDUCTED = 0;


    // Constructors
    public Ghost() {
        this(DEF_NAME, DEF_AGE, DEF_NUM_CANDY);
    }

    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = DEF_ROBBERIES_CONDUCTED;
    }


    // Methods
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        this.numCandy += 2;
    }
    
    private void rob(TrickOrTreater toBeRobbed) {
        // Undefined yet
    }

    public String toString() {
        return String.format("%s/%d", this.toString(), this.robberiesConducted);
    }

    public int compareTo(Object other) { ///////////////////////////////////////////////////
        if (other == null || !other.getClass().equals(this.getClass())) {
            return -2; // for personal debugging
        }

        Ghost temporary = new Ghost(); // using to get the class of Ghost.
        // I'm not too sure how to evaluate .equals the ghost class other than this.

        TrickOrTreater another = (TrickOrTreater) other;
        
        int simpleComparison = this.compareTo(another);
        
        if (other.getClass().equals(temporary.getClass())) {
            Ghost that = (Ghost) other;
            
            if (simpleComparison != 0) {
                return simpleComparison;
            } 

            if (this.robberiesConducted > that.robberiesConducted) {
                return 1;
            }

            if (this.robberiesConducted < that.robberiesConducted) {
                return -1;
            }

            if (this.robberiesConducted == that.robberiesConducted) {
                return 0;
            }

        } else {
            return (simpleComparison);
        }

        return -2;
        // -2 is error code
        // has a greater amount of robberies, return 1, less -1, equal 0
    }

}