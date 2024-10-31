package Sort;

public class BubbleSorter extends Sorter {
    public BubbleSorter() {
        super("Bubble Sorter");
    }

    // first attempt:
    //    faulty code, only does one pass
    //    after the first pass, the array may still be unsorted
    public void sort_v1(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
            }
        }
        printArray(array);
    }
    // second attempt: introduce passes
    public void sort_v2(int[] array) {
        // we only need n - 1 passes!
        for (int pass = 0; pass < array.length - 1; ++pass) {
            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            System.out.printf("Pass %s: ", pass + 1);
            printArray(array);
        }
    }
    // third attempt:
    //    no need to go through the whole array each time
    public void sort_v3(int[] array) {
        for (int pass = 0; pass < array.length - 1; ++pass) {
            for (int i = 0; i < array.length - 1 - pass; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            System.out.printf("Pass %s: ", pass + 1);
            printArray(array);
        }
    }
    // fourth attempt: simplify passes
    public void sort_v4(int[] array) {
        for (int pass = 1; pass < array.length; ++pass) {
            for (int i = 0; i < array.length - pass; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            System.out.printf("Pass %s: ", pass);
            printArray(array);
        }
    }
    // fifth attempt: optimize for swaps
    public void sort_v5(int[] array) {
        boolean needNextPass;
        for (int pass = 1; pass < array.length; ++pass) {
            needNextPass = false;
            for (int i = 0; i < array.length - pass; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    needNextPass = true;
                }
            }
            System.out.printf("Pass %s: ", pass + 1);
            printArray(array);
            if (!needNextPass) break;
        }
    }
    // sixth attempt: refactor code using end condition in the loop
    public void sort(int[] array) {
        boolean needNextPass = true;
        for (int pass = 1; pass < array.length && needNextPass; ++pass) {
            needNextPass = false;
            for (int i = 0; i < array.length - pass; ++i) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    needNextPass = true;
                }
            }
            System.out.printf("Pass %s: ", pass);
            printArray(array);
        }
    }
}
