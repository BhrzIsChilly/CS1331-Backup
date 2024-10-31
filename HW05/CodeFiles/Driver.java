import java.util.ArrayList;
public class Driver {
	public static void main(String[] args) {
		System.out.println("TESTING -------------------------------------------------------------");
		System.out.println();

		Store store1 = new Store("Store Uno");
		Store store2 = new Store("Store Dos");
		Store store3 = new Store("Store Tres");

		Dessert const1 = new IceCream();
		Dessert const2 = new IceCream(5, true);
		Dessert const3 = new IceCream("chocolate", 10.449, 5, false);
		Dessert const4 = new Cake("strawberry");
		Dessert const5 = new Cake("strawberry", -5.444, "creme");
		Dessert const6 = new Cake("strawberry", -5.444, "creme");
		Dessert const7 = new Cake("vanilla", -5.444, "creme");

		store1.addDessert(const1);
		store1.addDessert(const2);
		store1.addDessert(const3);
		store1.addDessert(const4);
		store1.addDessert(const5);
		store1.addDessert(const6);
		store1.addDessert(const7);

		store2.addDessert(const1);
		store2.addDessert(const2);
		store2.addDessert(const3);
		store2.addDessert(const4);
		store2.addDessert(const5);
		store2.addDessert(const6);
		store2.addDessert(const7);

		store3.addDessert(const1);
		store3.addDessert(const2);
		store3.addDessert(const3);
		store3.addDessert(const4);
		store3.addDessert(const5);
		store3.addDessert(const6);
		store3.addDessert(new IceCream("coconut", 11.0, 5, false));
		store3.addDessert(new Cake("mint chip"));

		ArrayList<Store> stores = new ArrayList<>();
		stores.add(store1);
		stores.add(store2);
		stores.add(store3);

		System.out.println("Cake and IceCream's toString() ---------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("vanilla ice cream with 1 scoops and does not have a cone.");
		System.out.println("vanilla ice cream with 5 scoops and has a cone.");
		System.out.println("chocolate ice cream with 5 scoops and does not have a cone.");
		System.out.println("strawberry cake with a vanilla frosting and has a sweetness of 45.00.");
		System.out.println("strawberry cake with a creme frosting and has a sweetness of -5.44.");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(const1.toString());
		System.out.println(const2.toString());
		System.out.println(const3.toString());
		System.out.println(const4.toString());
		System.out.println(const5.toString());
		System.out.println();

		System.out.println("Cake and IceCream's equals() -----------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("false");
		System.out.println("false");
		System.out.println("true");
		System.out.println("true");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(const1.equals(const2));
		System.out.println(const3.equals(const4));
		System.out.println(const6.equals(const5));
		System.out.println(const5.equals(const6));
		System.out.println();

		System.out.println("Dessert.java's compareTo() -------------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("3");
		System.out.println("1");
		System.out.println("0");
		System.out.println("-1");
		System.out.println("-3");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(const7.compareTo(const6));
		System.out.println(const1.compareTo(const6));
		System.out.println(const5.compareTo(const6));
		System.out.println(const6.compareTo(const2));
		System.out.println(const6.compareTo(const7));
		System.out.println();

		System.out.println("Store.java's removeDessert() -----------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("mint chip cake with a vanilla frosting and has a sweetness of 45.00.");
		System.out.println("null");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(store3.removeDessert(new Cake("mint chip")).toString());
		System.out.println(store3.removeDessert(new Cake("bad chip")));
		System.out.println();

		System.out.println("Store.java's sortStore() ---------------------------------------------");
		System.out.println("Expected Output:");
		System.out.printf("Store Uno's Menu of the Day:%nvanilla ice cream with 1 scoops and does not have a cone.%nvanilla ice cream with 5 scoops and has a cone.%nchocolate ice cream with 5 scoops and does not have a cone.%nstrawberry cake with a vanilla frosting and has a sweetness of 45.00.%nstrawberry cake with a creme frosting and has a sweetness of -5.44.%nstrawberry cake with a creme frosting and has a sweetness of -5.44.%nvanilla cake with a creme frosting and has a sweetness of -5.44.%n");
		System.out.printf("Store Uno's Menu of the Day:%nstrawberry cake with a creme frosting and has a sweetness of -5.44.%nstrawberry cake with a creme frosting and has a sweetness of -5.44.%nvanilla cake with a creme frosting and has a sweetness of -5.44.%nchocolate ice cream with 5 scoops and does not have a cone.%nstrawberry cake with a vanilla frosting and has a sweetness of 45.00.%nvanilla ice cream with 5 scoops and has a cone.%nvanilla ice cream with 1 scoops and does not have a cone.%n");
		System.out.println("Actual Output --------------------------------------------------------");
		store1.showMenu();
		store1.sortStore();
		store1.showMenu();
		System.out.println();

		System.out.println("Store.java's findDessert() -------------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("strawberry cake with a creme frosting and has a sweetness of -5.44.");
		System.out.println("strawberry cake with a creme frosting and has a sweetness of -5.44.");
		System.out.println("null");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(store1.findDessert(new Cake("strawberry", -5.444, "creme")));
		System.out.println(store1.findDessert(new Cake("strawberry", -5.444, "cherry")));
		System.out.println(store1.findDessert(new Cake("lol", -5.444, "creme")));
		System.out.println();

		System.out.println("Store.java's countGreaterDesserts() ----------------------------------");
		System.out.println("Expected Output:");
		System.out.println("7");
		System.out.println("4");
		System.out.println("0");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(store1.countGreaterDesserts(new Cake("abc", -5.444, "creme")));
		System.out.println(store1.countGreaterDesserts(new Cake("abc", 10.0, "creme")));
		System.out.println(store1.countGreaterDesserts(new Cake("strawberry", 46, "cherry")));
		System.out.println();

		store2.sortStore();
		store3.sortStore();
		System.out.println("Bob.java's compareStores() -------------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("true");
		System.out.println("true");
		System.out.println("false");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(Bob.compareStores(store1, store2));
		System.out.println(Bob.compareStores(store1, store1));
		System.out.println(Bob.compareStores(store1, store3));
		System.out.println();

		System.out.println("Bob.java's shop() ----------------------------------------------------");
		System.out.println("Expected Output:");
		System.out.println("true");
		System.out.println("true");
		System.out.println("false");
		System.out.println("Actual Output --------------------------------------------------------");
		System.out.println(Bob.shop(store1, new Cake("vanilla", -5.444, "creme")));
		System.out.println(Bob.shop(store2, new Cake("vanilla", -5.444, "creme")));
		System.out.println(Bob.shop(store3, new Cake("vanilla", -5.444, "creme")));
		System.out.println();

		System.out.println("Bob.java's findAvailableStores() -------------------------------------");
		System.out.println("Expected Output (testing lengths, check stores yourself LMAO):");
		System.out.println("3");
		System.out.println("2");
		System.out.println("1");
		System.out.println("0");
		System.out.println("Actual Output --------------------------------------------------------");
		ArrayList<Store> target1 = Bob.findAvailableStores(stores, new IceCream());
		ArrayList<Store> target2 = Bob.findAvailableStores(stores, new Cake("vanilla", -5.444, "creme"));
		ArrayList<Store> target3 = Bob.findAvailableStores(stores, new IceCream("coconut", 11.0, 5, false));
		ArrayList<Store> target4 = Bob.findAvailableStores(stores, new IceCream("banana", 1000.0, 5, false));
		System.out.println(target1.size());
		System.out.println(target2.size());
		System.out.println(target3.size());
		System.out.println(target4.size());
		System.out.println();
	}
}