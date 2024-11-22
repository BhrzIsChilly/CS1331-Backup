/*
*  Braiden Anderson
*  CS 1331
*  October 09, 2024
*/


public class FlyingFish extends Fish{
    private int flightTime; // in seconds invalid default to 30 invalid if nonpositive

    // Default values if invalid
    protected static final int DEF_FLIGHT_TIME_INVALID_SUB = 30;

    // Default constructor values
    protected static final String DEF_NAME = "Gilbert";
    protected static final Double DEF_LENGTH = 12.0;
    protected static final Double DEF_WEIGHT = 24.0;
    protected static final int DEF_FLIGHT_TIME = 36;

    // Constructors
    public FlyingFish() {
        this(DEF_NAME, DEF_LENGTH, DEF_WEIGHT, DEF_FLIGHT_TIME);
    }
    
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);
        this.flightTime = checkIntTypeInput(flightTime) ? flightTime : DEF_FLIGHT_TIME_INVALID_SUB;
    }
    
    public FlyingFish(FlyingFish toCopy) {
        super(toCopy);
        this.flightTime = toCopy.flightTime;
    }

    // Methods

    public double calculatePower() {
        return this.weight * this.flightTime;
    }

    public void fly() {
        double randomRoundedTime = Math.round(generateRandom(0.0, this.flightTime) * 100.0) / 100.0;
        System.out.printf("Woohoo! %s flew for %.2f seconds.", this.name, randomRoundedTime);
    }

    public String toString() {
        String fullFishStatement = super.toString();
        double roundedPower = Math.round(calculatePower() * 100.0) / 100.0;
        fullFishStatement += String.format(" I'm a flying fish, and my flight time record is %d, so my power is %.2f.", this.flightTime, roundedPower);
        return fullFishStatement;
    }


    // Helper methods -- made by me
    public static double generateRandom(double lowerEnd, double upperEnd) {
        return (lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }

    protected boolean checkIntTypeInput(int intInput) {
        return (intInput <= 0) ? false : true;
    }
}