package Sort;

public class Driver {
    public static void main(String[] args) {
        int[] array;
        Sorter sorter;

//        array = new int[]{91, 65, 34, 78, 29, 47, 56, 22};
//        array = new int[]{85, 41, 23, 99, 18, 59, 32, 71};
//        sorter = new SelectionSorter();
//        demo(array, sorter);

//        array = new int[]{91, 65, 34, 78, 29, 47, 56, 22};
//        array = new int[]{85, 41, 23, 99, 18, 59, 32, 71};
//        sorter = new BubbleSorter();
//        demo(array, sorter);

        array = new int[]{91, 65, 34, 78, 29, 47, 56, 22};
//        array = new int[]{85, 41, 23, 99, 18, 59, 32, 71};
        sorter = new InsertionSorter();
        demo(array, sorter);
    }

    public static void demo(int[] array, Sorter sorter) {
        System.out.printf("%n*** %s ***%n", sorter.getName());
        System.out.print("Before sorting: ");
        sorter.printArray(array);
        sorter.sort(array);
        System.out.print("After sorting: ");
        sorter.printArray(array);
    }
}
