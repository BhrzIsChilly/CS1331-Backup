public class MiniDriver {
    public static void main(String[] args) {
        SushiRoll[] sushiRolls = new SushiRoll[10];

        sushiRolls[0] = new SushiRoll("Salmon Roll", Color.BLUE);
        sushiRolls[1] = new SushiRoll("Tuna Roll", Color.RED);
        sushiRolls[2] = new SushiRoll("Eel Roll", Color.BLUE);
        sushiRolls[3] = new SushiRoll("Avocado Roll", Color.GREEN);
        sushiRolls[4] = new SushiRoll("Shrimp Roll", Color.RED);
        sushiRolls[5] = new SushiRoll("Cucumber Roll", Color.GREEN);
        sushiRolls[6] = new SushiRoll("Crab Roll", Color.RED);
        sushiRolls[7] = new SushiRoll("Egg Roll", Color.GREEN);
        sushiRolls[8] = new SushiRoll("Octopus Roll", Color.RED);
        sushiRolls[9] = new SushiRoll("Vegetable Roll", Color.GREEN);
        
        SushiRoll[] order1 = {
            new SushiRoll("Salmon Roll", Color.BLUE),
            new SushiRoll("Tuna Roll", Color.RED),
            new SushiRoll("Eel Roll", Color.GREEN)
        };

        SushiRoll[] order2 = {
            new SushiRoll("Avocado Roll", Color.GREEN),
            new SushiRoll("Shrimp Roll", Color.RED),
            new SushiRoll("Cucumber Roll", Color.GREEN)
        };

        SushiRoll[] order3 = {
            new SushiRoll("Crab Roll", Color.RED),
            new SushiRoll("Egg Roll", Color.GREEN),
            new SushiRoll("Octopus Roll", Color.BLUE)
        };

        SushiRoll[] order4 = {
            new SushiRoll("Vegetable Roll", Color.GREEN),
            new SushiRoll("Spider Roll", Color.RED),
            new SushiRoll("Dragon Roll", Color.BLUE)
        };

        // Combining these arrays into a 2D array called orders
        SushiRoll[][] orders = {order1, order2, order3, order4};

        // Print out the sushi rolls
        System.out.println("Before:");
        for (SushiRoll roll : sushiRolls) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\nAfter:");
        SushiRoll[] sortedRolls = Restaurant.mergeSortRolls(sushiRolls);
        for (SushiRoll roll : sortedRolls) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\n\nBefore:");
        for (int i = 0; i <orders.length; i++) {
            orders[i] = Restaurant.mergeSortRolls(orders[i]);
            for (SushiRoll roll : orders[i]) {
                System.out.println("Order " + i + ": " + roll);
            }
        }
        
        System.out.println("\n\n\nAfter:");
        SushiRoll[] sortedOrder = Restaurant.mergeOrders(orders);
        for (SushiRoll roll : sortedOrder) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\n\nBefore GREEN Color Filter:");
        sortedOrder = Restaurant.mergeOrders(orders);
        for (SushiRoll roll : sortedOrder) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\nAfter:");
        SushiRoll[] greenOrder = Restaurant.platesOfColor(sortedOrder, Color.GREEN);
        for (SushiRoll roll : greenOrder) {
            System.out.println(roll);
        }

        System.out.println("\n\n\n\nBefore Getting Price:");
        for (SushiRoll roll : sortedOrder) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\nAfter:");
        System.out.println(Restaurant.totalPrice(sortedOrder));
        
        System.out.println("\n\n\n\nBefore Flipping:");
        for (SushiRoll roll : sortedOrder) {
            System.out.println(roll);
        }
        
        System.out.println("\n\n\nAfter:");
        Restaurant.flip(sortedOrder);
        for (SushiRoll roll : sortedOrder) {
            System.out.println(roll);
        }

    }
}