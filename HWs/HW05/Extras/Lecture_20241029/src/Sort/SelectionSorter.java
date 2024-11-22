package Sort;

public class SelectionSorter extends Sorter {
    public SelectionSorter() {
        super("Selection Sorter");
    }

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j; // update happens
            }
            if (min != i)
                swap(array, i, min);
            System.out.printf("Pass %d: ", i+1);
            printArray(array);
        }
    }
}
