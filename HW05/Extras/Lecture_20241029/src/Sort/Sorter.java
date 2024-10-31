package Sort;

public abstract class Sorter {
    private String name;

    public Sorter(String name) {
        this.name = name;
    }

    public abstract void sort(int[] array);

    public void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    protected void swap(int[] array, int i, int j) {
        int temp = array[i]; // preserve ith element
        array[i] = array[j]; // overwrote ith element
        array[j] = temp; // set jth element to temp
    }
    public String getName() { return name; }
}
