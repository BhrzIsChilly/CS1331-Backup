package Sort;

public class InsertionSorter extends Sorter {
    public InsertionSorter() {
        super("Insertion Sorter");
    }

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentValue;
            System.out.printf("Pass %d: ", i);
            printArray(array);
        }
    }
}
