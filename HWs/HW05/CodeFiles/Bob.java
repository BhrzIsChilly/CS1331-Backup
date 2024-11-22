import java.util.ArrayList;
/**
 * Give me Bob! ;)
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Bob {
    // Methods
    /**
     * @param store1 the supposed subset, the first store in comparison.
     * @param store2 the supposed superset, the second store in comparison.
     * @return returns if store1 is a subset of store2.
     */
    public static boolean compareStores(Store store1, Store store2) {
        int numberOfEqualDesserts = 0;
        for (int i = 0; i < store1.getDessertsSize(); i++) { // for loop is O(n) --> combines to O(n log n)
            if (store2.findDessert(store1.getDessert(i)) != null) { // findDessert is O(log n)
                numberOfEqualDesserts++;
            }
        }

        if (numberOfEqualDesserts == store1.getDessertsSize()) {
            return true;
        }

        return false;
    }

    /**
     * @param store the Store that is being checked.
     * @param dessert the Dessert that is being checked for in the Store.
     * @return returns whether the passed in Store has the passed in Dessert.
     */
    public static boolean shop(Store store, Dessert dessert) {  // O(n^2 + log n) => O(n^2)
        store.sortStore(); // O(n^2)

        if (store.findDessert(dessert) != null) { // O(log n)
            return true;
        }
        return false;
    }

    /**
     * Can't use the shop method because it sorts the store, but in this method
     * we needO(n log m), so we can't allow for sorting inside this method.
     * @param stripMall an ArrayList of Stores to check for a targeted Desserts in.
     * @param targetDessert the Dessert we want to check for in the stripMall ArrayList.
     * @return returns an ArrayList of Stores that have the targetedDessert.
     */
    public static ArrayList<Store> findAvailableStores(ArrayList<Store> stripMall, Dessert targetDessert) {
        ArrayList<Store> goodStores = new ArrayList<>();
        for (int i = 0; i < stripMall.size(); i++) { // O(n) --> O(n log m)
            if (stripMall.get(i).findDessert(targetDessert) != null) { // O(m)
                goodStores.add(stripMall.get(i));
            }
        }
        return goodStores;
    }
}