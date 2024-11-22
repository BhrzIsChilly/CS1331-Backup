/**
 * Driver class to test LinkedList, LinkedListIterator, and Node.
 * @author Anonymous ;)
 * @version 1.0
 */
public class LinkedDriver {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<String>();
        System.out.println("Testing toArray(), getHead(), size(), isEmpty()," +
                " and LinkedListIterator for empty LinkedList:");
        System.out.println("    Expected output: []");
        System.out.print("    Actual output: ");
        Object[] arr = strings.toArray();
        printArray(arr);
        System.out.println("    Exepected output: null");
        System.out.print("    Actual output: ");
        System.out.println(strings.getHead());
        System.out.println("    Expected output: 0");
        System.out.print("    Actual output: ");
        System.out.println(strings.size());
        System.out.println("    Expected output: true");
        System.out.print("    Actual output: ");
        System.out.println(strings.isEmpty());

        //SOME TESTS FOR EXCEPTIONS:
        strings = new LinkedList<>(null);
        // strings = new LinkedList<>(new String[] {"A", null, "C", "D", "E", "F"});
        // strings.remove();
        // strings.remove(0);
        // strings.remove(-1);
        // strings.remove("A");
        // strings.remove(null);
        // strings.add(null);
        // strings.add(1, null);
        // strings.add(1, "A");
        // strings.add(-1, "A");
        // strings.set(1, null);
        // strings.set(1, "A");
        // strings.set(-1, "A");
        // strings.get(2);
        // strings.get(-1);
        // strings.contains(null);

        System.out.println("\nTesting add(T), get(index), and toArray() for non-empty LinkedList:");
        strings.add("B");
        strings.add(0, "B");
        strings.add("C");
        strings.add("E");
        System.out.println("    Expected output: [B, C, E]");
        System.out.print("    Actual output (printArray): ");
        arr = strings.toArray();
        printArray(arr);
        System.out.print("    Actual output (printList): ");
        printList(strings);


        System.out.println("\nTesting add(index, T):");
        strings.add(0, "A");
        strings.add(3, "D");
        strings.add(strings.size(), "F");
        System.out.println("    Expected output: [A, B, C, D, E, F]");
        System.out.print("    Actual output: ");
        printList(strings);


        System.out.println("\nTesting isEmpty(), size(), and getHead() (and also toString() I guess):");
        System.out.println("Expected output: ");
        System.out.println("===== LINKEDLIST 13648335 =====\n" +
                "isEmpty: false\n" +
                "size: 6\n" +
                "head: A\n" +
                "data: [A, B, C, D, E, F]\n" +
                "============================");
        System.out.println("Actual output: ");
        System.out.println(strings);


        System.out.println("\nTesting set(index):");
        strings.set(0, "X");
        strings.set(2, "Y");
        strings.set(strings.size() - 1, "Z");
        System.out.println("    Expected output: [X, B, Y, D, E, Z]");
        System.out.print("    Actual output: ");
        printList(strings);


        System.out.println("\nTesting contains():");
        System.out.println("    Expected output: false, true, true, true");
        System.out.print("    Actual output: ");
        System.out.println(strings.contains("A") + ", " + strings.contains("X") + ", " + strings.contains("D") + ", "
                + strings.contains("Z"));


        System.out.println("\nTesting remove():");
        System.out.println("    Expected output: X - 5 - [B, Y, D, E, Z]");
        System.out.print("    Actual output: " + strings.remove() + " - " + strings.size() + " - ");
        printList(strings);


        System.out.println("\nTesting remove(index):");
        System.out.println("    Expected output: Y, B, Z - 2 - [D, E]");
        System.out.print("    Actual output: " + strings.remove(1) + ", " + strings.remove(0) + ", "
                + strings.remove(strings.size() - 1) + " - " + strings.size() + " - ");
        printList(strings);


        System.out.println("\nTesting clear():");
        strings.clear();
        System.out.println("    Expected output: 0 - []");
        System.out.print("    Actual output: " + strings.size() + " - ");
        printList(strings);


        System.out.println("\nTesting LinkedList constructor:");
        strings = new LinkedList<>(new String[] {"A", "B", "C", "D", "E", "F"});
        System.out.println("    Expected: 6 - [A, B, C, D, E, F]");
        System.out.print("    Actual: " + strings.size() + " - ");
        printList(strings);


        System.out.println("\nTesting remove(T):");
        System.out.println("    Expected output: B - 5 - [A, C, D, E, F]");
        System.out.print("    Actual output: " + strings.remove("B") + " - " + strings.size() + " - ");
        printList(strings);
        System.out.println("    Expected output: A, F - 3 - [C, D, E]");
        System.out.print("    Actual output: " + strings.remove("A") + ", " + strings.remove("F")
                + " - " + strings.size() + " - ");
        printList(strings);


        System.out.println("\n\nIf all of your actual outputs are the same as your expected outputs, you *should* be "
                + "\ngood to go! Just to be sure, I'd recommend testing Exceptions, which I left commented"
                + "\nout of the driver near the top so the code would fully run first. Thanks for using my "
                + "\ndriver, and I hope you have a wonderful day! Best of luck!");
    }


    /**
     * Prints contents of an Object array.
     * @param arr The array being printed
     */
    public static void printArray(Object[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Prints contents of a LinkedList.
     * @param strings The LinkedList (presumably of Strings) being printed
     */
    public static void printList(LinkedList<String> strings) {
        System.out.print("[");
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i));
            if (i != strings.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}