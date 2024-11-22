/**
 * Give me Cookies and Cream icecream!.
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class IceCream extends Dessert {
    // Variables
    private int scoops;
    private boolean cone;


    // Default Variables
    private static final String DEF_FLAVOR = "vanilla";
    private static final double DEF_SWEETNESS = 45.0;
    private static final int DEF_SCOOPS = 1;
    private static final boolean DEF_CONE = false;


    // Constructors
    /**
     * Default values: Scoops = 1, Cone = false.
     */
    public IceCream() {
        this(DEF_SCOOPS, DEF_CONE);
    }

    /**
     * Default values: flavor = "vanilla", sweetness = 45.0.
     * @param scoops integer amount of scoops.
     * @param cone boolean of whether or not you want a cone.
     */
    public IceCream(int scoops, boolean cone) {
        this(DEF_FLAVOR, DEF_SWEETNESS, scoops, cone);
    }

    /**
     * @param flavor a String defining the flavor of the dessert
     * @param sweetness a double defining the sweetness of the dessert
     * @param scoops integer amount of scoops.
     * @param cone boolean of whether or not you want a cone.
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }


    // Methods
    @Override
    public String toString() {
        return String.format("%s ice cream with %d scoops and %s a cone.",
                            this.getFlavor(), this.scoops, (this.cone ? "has" : "does not have"));
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !other.getClass().equals(this.getClass())) {
            return false;
        }

        IceCream that = (IceCream) other;
        if (this.getFlavor() == that.getFlavor() && this.getSweetness() == that.getSweetness()) {
            if (this.scoops == that.scoops && this.cone == that.cone) {
                return true;
            }
        }

        return false;
    }
}