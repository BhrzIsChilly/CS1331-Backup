package Search;

public class Search {
    public static int linearSearch(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] numbers, int key) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == key) return mid;
            if (key < numbers[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 15, 4, 3, 6, 8, 11, 7};
        System.out.println(linearSearch(numbers, 8));
        System.out.println(linearSearch(numbers, 9));

        numbers = new int[] {2, 3, 4, 6, 7, 8, 11, 15};
        System.out.println(binarySearch(numbers, 8));
        System.out.println(binarySearch(numbers, 9));
    }
}
