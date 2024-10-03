/*
 * Braiden Anderson - HW 01
 * Car.java to represent the
 * Cars I collect
*/

public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    // Default values
    private static final int DEF_YEAR = 1960;
    private static final String DEF_MAKE = "Jaguar";
    private static final String DEF_MODEL = "E-Type";
    private static final String DEF_COLOR = "silver";
    private static final int DEF_CONDITION_CATEGORY = 89;

    // set methods for the constructors of the Car object

    private void setYear(int year) {        // No younger contemporary model than the 2025 models right now.
        if (year >= 1885 && year <= 2025) { // The first car was made in 1885, there's no older model than that.
            this.year = year;
        }
    }


    private void setMake(String make) {
        this.make = (make == null || make.isBlank()) ? DEF_MAKE : make; // modified from Dr. Landry's circle example
    }


    private void setModel(String model) {
        this.model = (model == null || model.isBlank()) ? DEF_MODEL : model;
    }


    private void setColor(String color) {
        this.color = (color == null || color.isBlank()) ? DEF_COLOR : color.toLowerCase();
    }


    private void setConditionCategory(int condition) {
        // ensures value stays between 40 and 100. Otherwise set to 80 as default.
        if (condition >= 40 && condition <= 100) {
            this.conditionCategory = condition;
        } else {
            this.conditionCategory = DEF_CONDITION_CATEGORY;
        }

        // prints out condition as it has become initialized.
        if (40 <= this.conditionCategory && this.conditionCategory <= 49) {
            System.out.println("Driver");
        } else if (50 <= this.conditionCategory && this.conditionCategory <= 59) {
            System.out.println("Good");
        } else if (60 <= this.conditionCategory && this.conditionCategory <= 69) {
            System.out.println("Very Good");
        } else if (70 <= this.conditionCategory  && this.conditionCategory <= 79) {
            System.out.println("Fine");
        } else if (80 <= this.conditionCategory && this.conditionCategory <= 89) {
            System.out.println("Excellent");
        } else if (90 <= this.conditionCategory && this.conditionCategory <= 100) {
            System.out.println("Perfect");
        }
    }

    ////////// END OF SETTERS //////////

    ////////// BEGINNING OF METHODS /////////

    public String[] getColorMakeModel() {
        String[] returnValue = {this.color, this.make, this.model};
        return returnValue;
    }

    public int getYear() {
        return this.year;
    }

    public int getConditionCategory() {
        return this.conditionCategory;
    }

    ////////// BEGINNING OF GETTERS //////////

    public Car() {
        this(DEF_YEAR, DEF_MAKE, DEF_MODEL);  // Precedes to call higher constructor.
    }


    public Car(int year, String make, String model) {
        this(year, make, model, DEF_COLOR, DEF_CONDITION_CATEGORY);
    }


    public Car(int year, String make, String model, String color, int conditionCategory) {
        setYear(year);
        setMake(make);
        setModel(model);
        setColor(color);
        setConditionCategory(conditionCategory);
    }
}