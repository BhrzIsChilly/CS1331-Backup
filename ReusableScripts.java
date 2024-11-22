public class ReusableScripts {
    public static void main(Strings[] args) {
        System.out.printf("Yep.");
    }
    
    // methods made by me. Improved from PE03. I made a fatal mistake T)_T)
    static int generateRandom(int lowerEnd, int upperEnd) {
        return (int)(lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }

    static double generateRandom(double lowerEnd, double upperEnd) {
        return (lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }


    //int low = 0, high = arr.length - 1;


    static int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void intArrayPrinter(int[] array) {
        for (int i : array) {
            System.out.printf("%d, ", i);
        }
    }



    // Works with non-primitives -- The base generic, T needs to be an instanceof Object, even if T[] is an Object itself.
    public static <T> void arrayPrinter(T[] array) {
        for (T i : array) {
            System.out.printf("%s, ", i.toString());
        }
    }

    private static boolean checkEmptyArray(SushiRoll[][] sushiOrders) {
        int sushiOrdersLength = sushiOrders.length;
        int sushiOrdersCounter = 0;

        if (sushiOrdersLength == 0) {
            return new SushiRoll[0];
        }

        for (SushiRoll[] order : sushiOrders) {
            if (order.length != 0) {
                sushiOrdersCounter++;
            }
        }

        if (sushiOrdersCounter == 0) {
            return new SushiRoll[0];
        }
    }

}