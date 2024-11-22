import java.util.ArrayList;

/**
 * Give me a store >:D.
 * @author Braiden Anderson
 * @version 1.0.0
 */

public class Store {
    // Variables
    private String name;
    private ArrayList<Dessert> desserts;


    // Constructor
    /**
     * Only constructor.
     * @param name A String defining the name of the store.
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }


    // Methods
    /**
     * @param object adds a Dessert object to the store.
     */
    public void addDessert(Dessert object) {
        desserts.add(object);
    }

    /**
     * @param object removes a Dessert object from the store.
     * @return Returns the exact Dessert object that was removed
     */
    public Dessert removeDessert(Dessert object) {
        for (int i = 0; i < getDessertsSize(); i++) {
            if (this.desserts.get(i).equals(object)) {
                Dessert removedDessert = this.desserts.get(i);
                this.desserts.remove(i);
                return removedDessert;
            }
        }
        return null;
    }

    /**
     * @param object searches for this Dessert object.
     * @return Returns the exact copy of the first Dessert object found that resembles the passed in Dessert object.
     */
    public Dessert findDessert(Dessert object) { // Binary search functionality taken and modified from lecture notes
        int low = 0;
        int high = desserts.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int middleValue = this.desserts.get(middle).compareTo(object);

            if (middleValue == 0) {
                if (this.desserts.get(middle).equals(object)) {
                    return this.desserts.get(middle);
                }
                return null;
            } else if (middleValue < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return null;
    }

    /**
     * Sorts the Desserts of the Store object this methods is called on.
     */
    public void sortStore() { // Ascending order O(n^2)
        int arraySize = getDessertsSize();
        for (int i = 0; i < arraySize; i++) {
            int min = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (this.desserts.get(j).compareTo(this.desserts.get(min)) < 0) {
                    min = j;
                }
            }

            if (min != i) {
                Dessert temp = this.desserts.get(i);
                this.desserts.set(i, this.desserts.get(min));
                this.desserts.set(min, temp);
            }

            // System.out.printf("Pass %d: ", i + 1);  // %debug
            // System.out.println(this.desserts);  // %debug
        }
    }

    /**
     * @param object Dessert object used to compare other Store Desserts with.
     * @return Returns the integer number of desserts that are comparably greater than the passed in Dessert object.
     */
    public int countGreaterDesserts(Dessert object) {
        int numberOfGreaterDesserts = 0;
        for (int i = 0; i < getDessertsSize(); i++) {
            if (this.desserts.get(i).compareTo(object) >= 0) {
                numberOfGreaterDesserts++;
            }
        }
        return numberOfGreaterDesserts;
    }

    /**
     * Prints a 'Menu' of Dessert objects.
     */
    public void showMenu() {
        System.out.printf("%s's Menu of the Day:\n", this.name);
        for (int i = 0; i < getDessertsSize(); i++) {
            System.out.printf("%s\n", this.desserts.get(i).toString());
        }
    }

    /**
     * @return return the size of the arraylist of the Store's Desserts.
     */
    public int getDessertsSize() {
        return this.desserts.size();
    }

    /**
     * @param i index to find a Dessert in the ArrayList of Desserts.
     * @return returns the Dessert at index i.
     */
    public Dessert getDessert(int i) {
        return this.desserts.get(i);
    }

}