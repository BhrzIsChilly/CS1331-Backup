/*
*  Braiden Anderson
*  CS 1331
*  October 09, 2024
*/


public class Fish {
    protected final String name;  // set when constructed. no other way to change. "Nemo" is default
    protected Double length; // Defaults to 8.0 invalid if not a number, infinite, nonpositive, or null
    protected Double weight; // DEF 2.0 not valid if not a number, infinite, nonpositive, or null.
    private static int totalFish; // this class only

    public static final double OZ_PER_LB = 16.0;
    public static final double IN_PER_FT = 12.0;

    // Default values per for invalid input
    protected static final Double DEF_LENGTH_INVALID_SUB = 8.0;  
    protected static final Double DEF_WEIGHT_INVALID_SUB = 2.0;

    // Default values for Constructors
    protected static final String DEF_NAME = "Nemo"; 
    protected static final Double DEF_LENGTH = 5.0;  
    protected static final Double DEF_WEIGHT = 12.0;

    // Reason for weird DEFAULT Values is due to inconsistencies in guidelines. Although they may be intentional, idk why though.

    // Constructor chainings
    public Fish() {
        this(DEF_NAME, DEF_LENGTH, DEF_WEIGHT);
    }

    public Fish(String name, Double length, Double weight) {
        this.name = checkNameInput(name) ? name : DEF_NAME;
        this.length = checkDoubleTypeInput(length) ? length : DEF_LENGTH_INVALID_SUB;
        this.weight = checkDoubleTypeInput(weight) ? weight : DEF_WEIGHT_INVALID_SUB;
    }

    public Fish(Fish toCopy) { // We can assume that the input will not be null
        this.name = toCopy.name;
        this.length = toCopy.length;
        this.weight = toCopy.weight; 
    }

    // Meaty Methods

    public String formatLength() {
        double unwrappedLength = this.length.doubleValue();
        int lengthFeet = (int) (unwrappedLength / IN_PER_FT);
        double lengthInches = (unwrappedLength % IN_PER_FT);
        lengthInches = Math.round(lengthInches * 100.0) / 100.0;
        if (lengthInches >= IN_PER_FT) {
            lengthFeet += 1;
            lengthInches -= IN_PER_FT;
        }
        
        // String formattedLengthToString = String.format("%d ft %.2f in", lengthFeet, lengthInches);
        return (String.format("%d ft %.2f in", lengthFeet, lengthInches));
    }

    public String formatWeight() {
        double unwrappedWeight = this.weight.doubleValue();
        int weightLbs = (int) (unwrappedWeight / OZ_PER_LB);
        double weightOz = unwrappedWeight % OZ_PER_LB;
        weightOz = Math.round(weightOz * 100.0) / 100.0;
        if (weightOz >= OZ_PER_LB) {
            weightLbs += 1;
            weightOz -= OZ_PER_LB;
        }

        // I fiddled around with code and realized that I could put both
        // formatLength's and formatWeight's code above into a helper
        // method, but it works, and I've almost completed the HW, so
        // I'm burnt out. I just wanted to acknowledge it at least.

        return (String.format("%d lb%s %.2f oz", weightLbs, (weightLbs > 1 ? "s" : ""), weightOz));
    }

    public String toString() {
        return (String.format("I'm a talking fish named %s. My length is %s and my weight is %s.", this.name, formatLength(), formatWeight()));
    }


    // Helper methods, not getters or setters
    private boolean checkNameInput(String name) {
        return (name == null || name.isBlank()) ? false : true;
    }

    protected boolean checkDoubleTypeInput(Double doubleInput) {
        if (doubleInput == null || doubleInput.isInfinite() || doubleInput.isNaN() || doubleInput <= 0) {
            return false;
        }  // I would make this into a ternary, but checkstyle doesn't like anythin over 120 chars.
        return true;
    }


}