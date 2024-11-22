/*
 * Braiden Anderson - HW 01
 * GarageOwner.java to represent
 * the owner of all the cars and
 * the garage
*/


public class GarageOwner {
    private String name;
    private int age;
    private int carsOwned = 0;

    private static final String DEF_NAME = "Braiden";  // for the empty constructor
    private static final int DEF_AGE = 19;             // not per the assignment



    ////// START OF SETTERS //////

    private void setName(String name) {
        this.name = (name == null || name.isBlank()) ? DEF_NAME : name;

    }

    private void setAge(int age) {
        if (0 <= age && age <= 120) {
            this.age = age;
        } else {
            this.age = DEF_AGE;
        }
    }


    //////     END OF SETTERS    //////



    //////   START OF GETTERS   //////


    public String getName() {
        return this.name;
    }

    public int getCarOwned() {
        return this.carsOwned;
    }


    ////// END OF GETTERS //////



    ////// START OF METHODS //////


    public void addCarCount(int carAmount) {
        this.carsOwned += carAmount;
    }


    ////// END OF METHODS //////



    ////// START OF CONSTRUCTORS //////


    public GarageOwner() {
        this(DEF_NAME, DEF_AGE);  // empty constructor for me, not per the assignment
    }

    public GarageOwner(String name, int age) {
        setName(name);
        setAge(age);

    }


    //////  END OF CONSTRUCTORS  //////

}