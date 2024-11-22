import java.util.Random;
import java.util.Hashtable;


public class Test1 {
    public static void main(String[] args) {
        /*
        for(int i = 0; i < 20; i++) {
            System.out.println(Test1.generateDRandom(0,5));
        }
        */
        Hashtable<Integer, Integer> distribution = new Hashtable<>();
        int lengthOfTest = 2000;
        int MAX = 20;
        int MIN = 1;
        int RANGE = MAX - MIN;

        Integer n = null;

        for (int i = 0; i < lengthOfTest; i++) {
            int tempRandomNumber = generateRandom(MIN, MAX);
            n = distribution.get(tempRandomNumber);
            if (n == null) {
                distribution.put(tempRandomNumber, 1);
            }
            if (n != null) {
                distribution.put(tempRandomNumber, n + 1);
            }
        }

        for(int i = 1; i <= MAX; i++) {
            n = distribution.get(i);
            System.out.printf("%2d %6d", i, n);
            for(int j = 1; j < n; j += 1) {
                System.out.printf("|");
            }
            System.out.printf("\n");
        }


        System.out.println("Mappings of distribution: " + distribution);
    }


    
    static int generateRandom(int lowerEnd, int upperEnd) {
        return (int)(lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }
    
    static double generateRandom(double lowerEnd, double upperEnd) {
        return (lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }

}