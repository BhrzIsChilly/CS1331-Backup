public class Test {

    public static void main(String[] args) {
        int[] order = new int[] {1,2,3,4,5};
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + ", ");
        }
        System.out.println("");
        flip(order);
        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + ", ");
        }

    }

    public static void flip(int[] order) {
        int i = 0;
        int temp;
        int orderLength = order.length;

        while (i < order.length) {
            temp = order[i];
            order[i] = order[orderLength - i - 1];
            order[orderLength - i - 1] = temp;

            i++;
        }
    }
}