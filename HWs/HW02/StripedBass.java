/*
*  Braiden Anderson
*  CS 1331
*  October 09, 2024
*/

public class StripedBass extends Fish {
    private int stripeCount;  // default to 25 -- invalid if nonpositive
    private boolean isSaltwater;   
    private Catfish bestFriend;

    // Default values if invalid
    protected static final int DEF_STRIPE_COUNT_INVALID_SUB = 25;

    // Default constructor values
    protected static final String DEF_NAME = "Striper";
    protected static final Double DEF_LENGTH = 30.0;
    protected static final Double DEF_WEIGHT = 320.0;
    protected static final int DEF_STRIPE_COUNT = 14;
    protected static final boolean DEF_IS_SALTWATER = false;
    protected static final Catfish DEF_BEST_FRIEND = null;

    // Constructors

    public StripedBass() {
        this(DEF_NAME, DEF_LENGTH, DEF_WEIGHT, DEF_STRIPE_COUNT, DEF_IS_SALTWATER, DEF_BEST_FRIEND);
    }
    
    public StripedBass(String name, Double length, Double weight, int stripeCount, boolean isSaltwater, Catfish bestFriend) {
        super(name, length, weight);
        this.stripeCount = checkIntTypeInput(stripeCount) ? stripeCount : DEF_STRIPE_COUNT_INVALID_SUB;
        this.isSaltwater = isSaltwater;
        this.bestFriend = (bestFriend == null) ? DEF_BEST_FRIEND : new Catfish(bestFriend); // copies the bestfriend catfish to this.bestfriend
    }

    public StripedBass(StripedBass toCopy) {
        super(toCopy);
        this.stripeCount = toCopy.stripeCount;
        this.isSaltwater = toCopy.isSaltwater;
        this.bestFriend = new Catfish(toCopy.bestFriend);
    }

    // Methods
    public void migrate() {
        this.isSaltwater = (this.bestFriend == null) ? !this.isSaltwater : this.isSaltwater; // inverts bass's location
    }

    public String toString() {
        String fullFishStatement = super.toString();
        fullFishStatement += String.format(" I'm a %s striped bass with %d stripes. I have %s.", formatIsSaltwater(), this.stripeCount, formatBestFriend());
        return fullFishStatement;
    }

    // Helper methods
    protected boolean checkIntTypeInput(int intInput) {
        return (intInput <= 0) ? false : true;
    }

    protected String formatIsSaltwater() {
        return String.format("%s", this.isSaltwater ? "saltwater" : "freshwater");
    }

    protected String formatBestFriend() {
        if (this.bestFriend == null) {
            return "no best friend";
        }
        return String.format("a best friend named %s", bestFriend.name);
    }
}