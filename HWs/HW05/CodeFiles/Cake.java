/**
 * Give me no cake! >:(
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Cake extends Dessert {
    // Variables
    private String frosting;


    // Default Variables
    private static final String DEF_FROSTING = "vanilla";
    private static final double DEF_SWEETNESS = 45.0;


    // Constructors
    /**
     * Default values: Frosting = "vanilla", sweetness = 45.0.
     * @param flavor a String defining the flavor of the dessert.
     */
    public Cake(String flavor) {
        this(flavor, DEF_SWEETNESS, DEF_FROSTING);
    }

    /**
     * @param flavor a String defining the flavor of the dessert.
     * @param sweetness a double defining the sweetness of the dessert.
     * @param frosting a String defining the frosting flavor of the dessert.
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }


    // Methods
    @Override
    public String toString() {
        return String.format("%s cake with a %s frosting and has a sweetness of %.2f.",
                            this.getFlavor(), this.frosting, this.getSweetness());
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }

        Cake that = (Cake) other;

        if (this.getFlavor() == that.getFlavor() && this.getSweetness() == that.getSweetness()) {
            if (this.frosting == that.frosting) {
                return true;
            }
        }

        return false;
    }

}