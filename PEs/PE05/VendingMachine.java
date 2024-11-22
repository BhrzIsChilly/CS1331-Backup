import java.util.ArrayList;


/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class VendingMachine {
    // Variables
    private ArrayList<String> stock;
    private int cost;


    // Constructors
    /**
     * @param stock an ArrayList of (Type: String) of the items present in the VendingMachine.
     * @param cost the uniform cost of each item in the VendingMachine.
     */
    public VendingMachine(ArrayList<String> stock, int cost) {
        this.stock = stock; // shallow copying as allowed by PE05 instructions.
        this.cost = cost;
    }


    // Methods
    /**
     * @param order an ArrayList of (Type: String) of the items the method caller wants to purchase.
     */
    public void checkStock(ArrayList<String> order) throws IllegalArgumentException, OutOfStockException {

        if (order == null) {
            throw new IllegalArgumentException("You imagined ordering, yet, in reality, you did not order.");
        }

        for (int i = 0; i < order.size(); i++) {
            if (!this.stock.contains(order.get(i))) {
                throw new OutOfStockException(order.get(i));
            }
        }

        System.out.println("All items are in stock!");
    }

    /**
     * @param item the String item that you want to potentially buy from the VendingMachine.
     * @param money the int money that you input into the VendingMachine to use to purchase the item.
     */
    public void buyItem(String item, int money) throws
        IllegalArgumentException, OutOfStockException, NotEnoughMoneyException {
        if (item == null) {
            throw new IllegalArgumentException("Item was input as null.\n\tError: Item = null");
        }

        if (checkStockSingleItem(item)) {
            if (money >= this.cost) {
                System.out.println(this.stock); // %debug
                this.stock.remove(item);
                System.out.printf("%s successfully vended!\n", item);
                System.out.println(this.stock); // %debug
                return;
            } else {
                throw new NotEnoughMoneyException();
            }

        } else {
            throw new OutOfStockException(item);
        }
    }

    /**
     * @param favoriteItems an ArrayList of (Type: String) of your favoriteItems
     * @return an ArrayList of (Type: String) of the items available in the VendingMachine.
     */
    public ArrayList<String> availableFavorites(ArrayList<String> favoriteItems)
        throws IllegalArgumentException, OutOfStockException {

        if (favoriteItems == null) {
            throw new IllegalArgumentException("favoriteItems ArrayList was null");
        }
        ArrayList<String> available = new ArrayList<>();

        for (int i = 0; i < this.stock.size(); i++) {
            if (checkStockSingleItem(favoriteItems.get(i))) {
                available.add(favoriteItems.get(i));
            }
        }

        return available;
    }


    // Helper Methods
    /**
     * @param item String item to be used to check the VendingMachine for a singular item.
     * @return returns a boolean indicating whether the item is in stock or not.
     */
    public boolean checkStockSingleItem(String item) {
        if (!this.stock.contains(item)) {
            return false;
        }

        return true;
    }


    // Main method
    /**
     * @param args inputs the arguments from the command line.
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<String>(5);
        vendingItems.add("Mountain Dew");
        vendingItems.add("Coke");
        vendingItems.add("Sprite");
        vendingItems.add("Monster Energy");
        vendingItems.add("Italian Special");

        ArrayList<String> favorites = new ArrayList<String>(5);
        favorites.add("Sprite");
        favorites.add("Monster Energy");
        favorites.add("French Special");

        VendingMachine vendingMachine = new VendingMachine(vendingItems, 200);

        try {
            vendingMachine.checkStock(vendingItems);

            vendingMachine.buyItem("Sprite", 250);
            vendingMachine.buyItem("Sprite", 199);
            vendingMachine.buyItem("French Special", 250);
            vendingMachine.buyItem("Hot Lava", 109);

            ArrayList<String> favoritesAvailable = vendingMachine.availableFavorites(favorites);

            for (String i: favoritesAvailable) {
                System.out.println(i);
            }

        } catch (OutOfStockException oose) {
            System.out.println(oose.getMessage());
        } catch (NotEnoughMoneyException neme) {
            System.out.println(neme.getMessage());
        } finally {
            System.out.println("Took a trip to the vending machine!");
        }
    }
}