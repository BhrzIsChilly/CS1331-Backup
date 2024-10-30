/*
* Braiden Anderson
* CS 1331  --  10/22/2024
* Witch.java
*/

public class Witch extends TrickOrTreater implements Robbable {
    // Variables
    private String signatureCackle;


    // Default Variables
    private static final String DEF_NAME = "Maleficent";
    private static final int DEF_AGE = 7;
    private static final int DEF_NUM_CANDY = 0;
    private static final String DEF_SIGNATURE_CACKLE = "Bwahaha";


    // Constructors
    public Witch() {
        this(DEF_NAME, DEF_AGE, DEF_NUM_CANDY, DEF_SIGNATURE_CACKLE);
    }

    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);

        if ((signatureCackle == null) || signatureCackle.isBlank()) {
            this.signatureCackle = DEF_SIGNATURE_CACKLE;
        } else {
            this.signatureCackle = signatureCackle;
        }
        this.robbable = true;
    }


    // Methods
    public void trickOrTreat() {
        System.out.printf("%s! I'll get you my pretty!", this.signatureCackle);
        this.numCandy += 3;
    }

    public int compareTo(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return -2; // for personal debugging
        }

        Witch temporary = new Witch(); // Same as the problem with Ghost's compareTo

        TrickOrTreater another = (TrickOrTreater) other;
        
        int simpleComparison = this.compareTo(another);
        
        if (other.getClass().equals(temporary.getClass())) {
            Witch that = (Witch) other;
            
            if (simpleComparison != 0) {
                return simpleComparison;
            } 

            int thisCackleLength = this.signatureCackle.length();
            int thatCackleLength = that.signatureCackle.length();

            if (thisCackleLength > thatCackleLength) {
                return 1;
            }

            if (thisCackleLength < thatCackleLength) {
                return -1;
            }

            if (thisCackleLength == thatCackleLength) {
                return 0;
            }

        } else {
            return (simpleComparison);
        }

        return -2;
        // -2 is error code
        // has a greater amount of robberies, return 1, less -1, equal 0
    }

    public int beRobbed() {
        int initialCandy = this.numCandy;
        this.numCandy -= 6;
        if (this.numCandy < 0) {
            this.numCandy = 0;
            return initialCandy;
        }
        return 6;
    }


}