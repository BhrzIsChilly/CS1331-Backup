/**
 * What do you want from me?
 * @author Braiden Anderson
 * @version 1.0.0
 */

public abstract class Dessert implements Comparable<Dessert> {
    // Variables
    private String flavor;
    private double sweetness;


    // Default Variables
    private static final String DEF_FLAVOR = "vanilla";
    private static final double DEF_SWEETNESS = 25.0;


    // Getters
    /**
     * @return returns the flavor as a String.
     */
    public String getFlavor() {
        return (this.flavor);
    }

    /**
     * @return returns the sweetness as a double.
     */
    public double getSweetness() {
        return (this.sweetness);
    }


    // Constructors
    /**
     * Empty constructor.
     * Defaults flavor to "vanilla".
     * Defaults sweetness to 25.0.
     */
    public Dessert() {
        this(DEF_FLAVOR, DEF_SWEETNESS);
    }

    /**
     * @param flavor a String defining the flavor of the dessert
     * @param sweetness a double defining the sweetness of the dessert
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }


    // Methods
    @Override
    public String toString() {
        return String.format("%s dessert with a sweetness of %.2f.", this.flavor, this.sweetness);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }

        Dessert that = (Dessert) other;

        if (this.flavor == that.flavor && this.sweetness == that.sweetness) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Dessert other) {
        if (this.sweetness > other.sweetness) {
            return 1;
        }
        if (this.sweetness < other.sweetness) {
            return -1;
        }
        return (this.flavor.compareTo(other.flavor)); // only evaluates if sweetnesses are equal.
    }


}