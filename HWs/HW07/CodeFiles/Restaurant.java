/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Restaurant {
    /**
     * @param order the order we're looking at merging.
     * @return returns a mergedOrder of rolls.
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] order) {
        if (order.length > 1) {
            int middle = order.length / 2;

            SushiRoll[] array1 = RecursionUtils.copyOfRange(order, 0, middle);
            SushiRoll[] array2 = RecursionUtils.copyOfRange(order, middle, order.length);

            array1 = mergeSortRolls(array1);
            array2 = mergeSortRolls(array2);

            return RecursionUtils.merge(array1, array2);
        }

        return order;
    }
    /**
     * @param sushiOrders inputs a 2D array of sushi. array of orders
     * @return returning the merged order
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] sushiOrders) {
        if (checkEmptyArray(sushiOrders)) {
            return new SushiRoll[0];
        }
        int index = 0;

        SushiRoll[] completeOrder = sushiOrders[index++];

        return mergeOrdersHelper(sushiOrders, completeOrder, index);
    }

    /**
     * @param order the list of sushi we're looking at.
     * @param desiredColor used to find the desired color of plate
     * @return returning an order of color coordinated sushi
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] order, Color desiredColor) {
        SushiRoll[] colorCoordinatedSushi = new SushiRoll[0];
        int index = 0;

        return platesOfColorHelper(order, desiredColor, colorCoordinatedSushi, index);
    }

    /**
     * @param order the list of sushi we're looking at.
     * @return returns the price of the order.
     */
    public static double totalPrice(SushiRoll[] order) {
        int index = 0;
        double price = 0.0;
        return totalPriceHelper(order, index, price);
    }

    /**
     * @param order the list of sushi we're looking at flipping.
     */
    public static void flip(SushiRoll[] order) {
        int index = 0;
        SushiRoll tempSushi = new SushiRoll("temp");
        int orderLength = order.length;

        flipHelper(order, index, tempSushi, orderLength);
    }

    // Helper method
    /**
     * @param order the list of sushi we're looking at flipping.
     * @param i indexes the step
     * @param tempSushi placeholder sushi for swapping
     * @param orderLength gives us the orderLength in a conventient fashion.
     */
    public static void flipHelper(SushiRoll[] order, int i, SushiRoll tempSushi, int orderLength) {
        if (i == orderLength / 2) {
            return;
        }

        tempSushi = order[i];
        order[i] = order[orderLength - i - 1];
        order[orderLength - i++ - 1] = tempSushi;

        flipHelper(order, i, tempSushi, orderLength);
    }

    /**
     * @param order the list of sushi we're looking at
     * @param i indexes the step
     * @param price the price we're adding to and returning
     * @return we're returning the price
     */
    public static double totalPriceHelper(SushiRoll[] order, int i, double price) {
        if (i == order.length) {
            return price;
        }

        price += order[i++].getColor().getPrice();

        return totalPriceHelper(order, i, price);
    }

    /**
     * @param order the list of sushi we're looking at
     * @param desiredColor used to find the desired color of plate
     * @param colorCoordinatedSushi helper parameter to combine orders
     * @param i indexes the step
     * @return returning an order of color coordinated sushi
     */
    private static SushiRoll[] platesOfColorHelper(SushiRoll[] order,
        Color desiredColor, SushiRoll[] colorCoordinatedSushi, int i) {
        if (i == order.length) {
            return colorCoordinatedSushi;
        }

        if (order[i].getColor() == desiredColor) {
            SushiRoll[] singleRoll = new SushiRoll[] {order[i]};
            colorCoordinatedSushi = RecursionUtils.merge(colorCoordinatedSushi, singleRoll);
        }

        i++;

        return platesOfColorHelper(order, desiredColor, colorCoordinatedSushi, i);
    }

    /**
     * @param sushiOrders inputs a 2D array of sushi. array of orders
     * @param completeOrder helper parameter to combine orders
     * @param index indexes the step
     * @return returning the merged order
     */
    private static SushiRoll[] mergeOrdersHelper(SushiRoll[][] sushiOrders, SushiRoll[] completeOrder, int index) {
        if (index == sushiOrders.length) {
            return completeOrder;
        }

        completeOrder = RecursionUtils.merge(completeOrder, sushiOrders[index++]);

        return mergeOrdersHelper(sushiOrders, completeOrder, index);
    }

    /**
     * @param sushiOrders inputs a 2D array of sushi. array of orders
     * @return returns true if is empty false if not
     */
    private static boolean checkEmptyArray(SushiRoll[][] sushiOrders) { // can't have a loop
        if (sushiOrders == null || sushiOrders.length == 0) {
            return true;
        }

        return false;
    }
}