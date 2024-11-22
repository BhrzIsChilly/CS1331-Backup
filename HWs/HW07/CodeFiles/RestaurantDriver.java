public class RestaurantDriver {
    public static void main(String[] args) {
        SushiRoll[] empty = new SushiRoll[0];

        System.out.println("mergeSortRolls TEST:");
        System.out.println("Input:");
        SushiRoll[] rolls = new SushiRoll[] {new SushiRoll("Tobiko"), new SushiRoll("Avocado"),
                new SushiRoll("Unagi"), new SushiRoll("Dragon"), new SushiRoll("Maki")};
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }
        System.out.println("=".repeat(60));
        rolls = Restaurant.mergeSortRolls(rolls);
        System.out.println("Output:");
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }



        //Testing sorting an empty array
        SushiRoll[] emptyRolls = Restaurant.mergeSortRolls(empty);



        System.out.println("\nmergeOrders TEST:");
        System.out.println("Input arrays:");
        SushiRoll[][] orders = new SushiRoll[][] {{new SushiRoll("Avocado"), new SushiRoll("Dragon")},
                {new SushiRoll("Tobiko"), new SushiRoll("Unagi")}, {new SushiRoll("Maki")}};
        for (int i = 0; i < orders.length; i++) {
            System.out.print("[");
            for (int j = 0; j < orders[i].length; j++) {
                System.out.print(orders[i][j]);
                if (j < orders[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("=".repeat(60));
        SushiRoll[] sortedOrders = Restaurant.mergeOrders(orders);
        System.out.println("Output array:");
        for (int i = 0; i < sortedOrders.length; i++) {
            System.out.println(sortedOrders[i]);
        }
        //Testing emptyOrders on an array of empty arrays
        SushiRoll[][] emptyOrders = new SushiRoll[][] {empty};
        SushiRoll[] ordersEmpty = Restaurant.mergeOrders(emptyOrders);
        //Testing emptyOrders on an empty array
        SushiRoll[][] trulyEmpty = new SushiRoll[0][0];
        SushiRoll[] emptyTruly = Restaurant.mergeOrders(trulyEmpty);



        System.out.println("\nplatesOfColor TEST:");
        SushiRoll[] sortedRolls = new SushiRoll[] {new SushiRoll("Avocado", Color.BLUE),
                new SushiRoll("Dragon", Color.BLUE), new SushiRoll("Maki", Color.RED),
                new SushiRoll("Rainbow", Color.GREEN), new SushiRoll("Unagi", Color.RED)};
        for (int i = 0; i < sortedRolls.length; i++) {
            System.out.println(sortedRolls[i]);
        }
        System.out.println("=".repeat(60));
        System.out.println("RED:");
        SushiRoll[] sortedRollsRed = Restaurant.platesOfColor(sortedRolls, Color.RED);
        for (int i = 0; i < sortedRollsRed.length; i++) {
            System.out.println(sortedRollsRed[i]);
        }
        System.out.println("BLUE:");
        SushiRoll[] sortedRollsBlue = Restaurant.platesOfColor(sortedRolls, Color.BLUE);
        for (int i = 0; i < sortedRollsBlue.length; i++) {
            System.out.println(sortedRollsBlue[i]);
        }
        System.out.println("GREEN:");
        SushiRoll[] sortedRollsGreen = Restaurant.platesOfColor(sortedRolls, Color.GREEN);
        for (int i = 0; i < sortedRollsGreen.length; i++) {
            System.out.println(sortedRollsGreen[i]);
        }

        //Testing on an empty array
        System.out.println("EMPTY:");
        SushiRoll[] sortedEmpty = Restaurant.platesOfColor(empty, Color.RED);

        //Testing null color
        System.out.println("NULL:");
        SushiRoll[] sortedRollsNull = Restaurant.platesOfColor(sortedRolls, null);
        for (int i = 0; i < sortedRollsNull.length; i++) {
            System.out.println(sortedRollsNull[i]);
        }



        System.out.println("\ntotalPrice TEST:");
        System.out.println("rolls price [Expected: 15.0]: " + Restaurant.totalPrice(rolls));
        System.out.println("sortedRolls price [Expected: 15.0]: " + Restaurant.totalPrice(sortedRolls));
        System.out.println("empty price [Expected: 0.0]: " + Restaurant.totalPrice(empty));



        System.out.println("\nflip TEST:");
        System.out.println("Input:");
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }
        System.out.println("=".repeat(60));
        Restaurant.flip(rolls);
        System.out.println("Output:");
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }
        System.out.println();

        //Testing flipping an empty array
        Restaurant.flip(empty);

        //Testing flipping an array with an even number of elements
        rolls = RecursionUtils.merge(rolls, new SushiRoll[] {new SushiRoll("Numsix")});
        rolls = Restaurant.mergeSortRolls(rolls);
        System.out.println("Input:");
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }
        System.out.println("=".repeat(60));
        Restaurant.flip(rolls);
        System.out.println("Output:");
        for (int i = 0; i < rolls.length; i++) {
            System.out.println(rolls[i]);
        }
        System.out.println();


    }
}