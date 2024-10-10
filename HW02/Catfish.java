/*
*  Braiden Anderson
*  CS 1331
*  October 09, 2024
*/

public class Catfish extends Fish{
    private Double whiskerLength; // in inches - default 8.0

    // Default values for invalid input
    protected static final Double DEF_WHISKER_LENGTH_INVALID_SUB = 8.0;

    // Default Constructor values
    protected static final String DEF_NAME = "Bubba";
    protected static final Double DEF_LENGTH = 52.0;
    protected static final Double DEF_WEIGHT = 720.0;
    protected static final Double DEF_WHISKER_LENGTH = 5.0;

    // Constructors
    public Catfish() {
        this(DEF_NAME, DEF_LENGTH, DEF_WEIGHT, DEF_WHISKER_LENGTH);
    }

    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        setWhiskerLength(whiskerLength);
    }

    public Catfish(Catfish toCopy) { // we can assume that input will not be null
        super(toCopy);
        this.whiskerLength = toCopy.whiskerLength;
        System.out.println(this.name);
    }

    // Methods
    public void setWhiskerLength(double whiskerLength) {
        this.whiskerLength = (super.checkDoubleTypeInput(whiskerLength) ? whiskerLength : DEF_WHISKER_LENGTH_INVALID_SUB);
    }
    
    public boolean isShaggy() {
        return (this.whiskerLength > this.length ? true : false);
    }

    public String toString() {
        String fullFishStatement = super.toString();
        fullFishStatement += String.format(" I'm a catfish whose longest whisker is %s.", formatShaggy());  // should include "in"
        return fullFishStatement;
    }

    // Helper methods

    private String formatShaggy() {
        double unwrappedWhiskerLength = this.whiskerLength.doubleValue();
        unwrappedWhiskerLength = Math.round(unwrappedWhiskerLength * 100.0) / 100.0;
        
        return (String.format("%.2f, so I am%s shaggy", unwrappedWhiskerLength, (isShaggy() ? "" : " not")));
    }

}