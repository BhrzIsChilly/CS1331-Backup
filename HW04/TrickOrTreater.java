/*
* Braiden Anderson
* CS 1331  --  10/22/2024
* TrickOrTreater.java
*/
// Attempt to make an abstract class final
// when a class is made final, you are unable to create a child class.
// when a method is made final, you are unable to override the method.

package yum; // %debug

public abstract class TrickOrTreater {
    // Variables
    protected String name;
    protected int age;
    protected int numCandy; 


    // Default variables
    private static final String DEF_NAME = "Chowder";
    private static final int DEF_AGE = 8;
    private static final int DEF_NUM_CANDY = 0;

    // Constructors
    public TrickOrTreater(String name, int age, int numCandy) {
        if ((name == null) || name.isBlank()) {
            this.name = DEF_NAME;
        } else {
            this.name = name;
        }
        
        if (age > 12 || age < 0) {
            this.age = DEF_AGE;
        } else {
            this.age = age;
        }

        if (numCandy < 0) {
            this.numCandy = DEF_NUM_CANDY;
        } else {
            this.numCandy = numCandy;
        }
    }


    // Methods

    // Abstract methods
    public abstract void trickOrTreat();

    
    // Concrete methods
    protected void gainCandy(int numCandyGain) {
        if (numCandyGain > 0) {
            this.numCandy += numCandyGain;
        }
    }

    protected int loseCandy(int numCandyLose) {
        int initialCandy = this.numCandy;

        if (numCandyLose > 0) {
            this.numCandy -= numCandyLose;
        }

        if (this.numCandy < 0) {
            this.numCandy = 0;
            return initialCandy;
        }

        return numCandyLose;
    }

    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }

    public int compareTo(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return -2; // for personal debugging
        }

        TrickOrTreater that = (TrickOrTreater) other;


        if (this.numCandy > that.numCandy) {
            return 1;
        }

        if (this.numCandy < that.numCandy) {
            return -1;
        }

        if (this.numCandy == that.numCandy) {
            if (this.age > that.age) {
                return 1;
            }

            if (this.age < that.age) {
                return -1;
            }

            if (this.age == that.age) {
                return 0;
            }
        }

        return -2;
        
        // -2 is error code
        // has a greater amount of candy return 1; less return -1; same: check age.
        // greater age return 1; lesser age return -1 same age return 0; 
    }

    public int getNumCandy() {
        return this.numCandy;
    }
}