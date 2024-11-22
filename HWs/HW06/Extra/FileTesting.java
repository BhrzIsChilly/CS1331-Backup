import java.io.File;

public class FileTesting {
    public static void main(String[] args) {
        int[] array = new int[] {1,5,2,6,8,3,4,7,9};
        int[] sorted = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        
        int tempInt;

        intArrayPrinter(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    tempInt = array[i];
                    array[i] = array[j];
                    array[j] = tempInt;
                }
            }
        }

        intArrayPrinter(array);

    }

    public static void intArrayPrinter(int[] array) {
        for (int i : array) {
            System.out.printf("%d, ", i);
        }
        System.out.print("\n");
    }
}