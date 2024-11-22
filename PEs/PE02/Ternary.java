// Shreyas

public class Ternary {
    public static void main(String[] args) {
        int initialNum = 298;
        String answer = "";
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        int currentNum = initialNum;

        while (currentNum != 0) {
            int digit = currentNum % 3;
            if (digit == 0)
                zeroCount++;
            if (digit == 1)
                oneCount++;
            if (digit == 2)
                twoCount++;
            answer = digit + answer;
            currentNum /= 3;
        }
        System.out.printf("Decimal representation: %d\n", initialNum);
        System.out.printf("Ternary representation: %s\n", answer);
        System.out.printf("%d zeros, %d ones, and %d twos\n", zeroCount, oneCount, twoCount);


    }
}