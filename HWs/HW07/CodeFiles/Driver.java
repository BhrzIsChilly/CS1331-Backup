public class Driver {
    public static void main(String[] args) {
        System.out.println("===========Testing mergeSortRolls()===============");
        SushiRoll s1 = new SushiRoll("Tobiko", Color.BLUE);
        SushiRoll s2 = new SushiRoll("Avocado");
        SushiRoll s3 = new SushiRoll("Unagi", Color.BLUE);
        SushiRoll s4 = new SushiRoll("Dragon");
        SushiRoll s5 = new SushiRoll("Maki", Color.RED);
        SushiRoll[] s = new SushiRoll[]{s1, s2, s3, s4, s5};
        System.out.println("*********BEFORE SORTING**********");
        for (SushiRoll roll : s) {
            System.out.print(roll.toString() + " ");
        }
        System.out.println("");
        SushiRoll[] sortedRolls = Restaurant.mergeSortRolls(s);
        System.out.println("*************AFTER SORTING*******");
        for (SushiRoll roll : sortedRolls) {
            System.out.print(roll.toString() + " ");
        }
        System.out.println();
        System.out.println();
        
        System.out.println("===========Testing mergeOrders()===============");
        SushiRoll[][] unsortedOrders = {
            {new SushiRoll("Avocado"), new SushiRoll("Dragon", Color.RED)},
            {new SushiRoll("Tobiko", Color.BLUE), new SushiRoll("Unagi")},
            {new SushiRoll("Maki")}
        };
        SushiRoll[] sortedOrders = Restaurant.mergeOrders(unsortedOrders);
        for (SushiRoll roll : sortedOrders) {
            System.out.print(roll.toString() + " ");
        }
        System.out.println();
        System.out.println();

        
        System.out.println("===========Testing platesOfColor()===============");
        s1 = new SushiRoll("Avocado", Color.BLUE);
        s2 = new SushiRoll("Dragon", Color.BLUE);
        s3 = new SushiRoll("Maki", Color.RED);
        s4 = new SushiRoll("Rainbow");
        s5 = new SushiRoll("Unagi", Color.RED);
        s = new SushiRoll[]{s1, s2, s3, s4, s5};
        SushiRoll[] resultPlatesOfColor = Restaurant.platesOfColor(s, Color.RED);
        for (SushiRoll roll : resultPlatesOfColor) {
            System.out.print(roll.toString() + " ");
        }
        System.out.println();
        System.out.println();

        
        System.out.println("===========Testing totalPrice()==============");
        // the array s is the same as the one used to test plates of color.
        System.out.println(Restaurant.totalPrice(s));
        System.out.println();


        System.out.println("===========Testing flipSushiRoll()==============");
        s1 = new SushiRoll("Avocado", Color.BLUE);
        s2 = new SushiRoll("Dragon", Color.BLUE);
        s3 = new SushiRoll("Maki", Color.RED);
        s4 = new SushiRoll("Tobiko");
        s5 = new SushiRoll("Unagi", Color.RED);
        s = new SushiRoll[]{s1, s2, s3, s4, s5};
        System.out.println("***Before applying the method***");
        for (SushiRoll roll : s) {
            System.out.print(roll.toString() + " ");
        }
        System.out.println();
        System.out.println("***After applying the method***");
        Restaurant.flip(s);
        for (SushiRoll roll : s) {
            System.out.print(roll.toString() + " ");
        }
    }
}