import java.util.Scanner;
import java.util.Random;

public class RandomMath {
    public static void main(String[] args) {
        System.out.printf("1, Powers of a Number\n2, Random Positivie Integer with Maximum\n3, Area of Random Circle\n4, Area of Random Square\nWhat would you like to do?\n");
        
        Scanner scannerObject = new Scanner(System.in);
        int userInput = scannerObject.nextInt();
        switch(userInput) {
            case 1:
                RandomMath.powerNumbers();
                break;
            case 2:
                RandomMath.randomIntWithMax();
                break;
            case 3:
                RandomMath.circleArea();
                break;
            case 4:
                RandomMath.randomSquareArea();
                break;
            default:
                System.out.println("Invalid user input, type a number 1-4.");
                break;
        }
    }

    static void powerNumbers() {
        System.out.println("What number would you like to calculate powers of?");
        Scanner scannerObject = new Scanner(System.in);
        int userInput = scannerObject.nextInt();
        switch(userInput) {
            case -1:
                System.out.printf("-1 raised to 0 is 1\n-1 raised to odd powers freater than 0 is -1\n-1 raised to even powers greater than 0 is 1\n");
                break;
            case 0:
                System.out.printf("0 raised to the 0 is 1\n0 raised to the powers greater than 0 is 0\n");
                break;
            case 1:
                System.out.printf("1 raised to ANY power is still 1\n");
                break;
            default:
                int i = 0;
                do {
                double poweredNumber = Math.pow(userInput, i++);
                System.out.printf("%d raised to the %d is %.0f.\n", userInput, i-1, poweredNumber);
                } while (Math.abs(Math.pow(userInput, i)) <= 100);
        }       
    }

    static boolean randomIntWithMax() {
        System.out.println("What is the max value you want your random number to be? ");
        Scanner scannerObject = new Scanner(System.in);
        int userInput = scannerObject.nextInt();
        if(userInput <= 0) {
            System.out.println("User input must be positive and non-zero.");
            return true;
        }
        double randomNumber = RandomMath.generateRandom(1, userInput);
        System.out.printf("Your random number is %.0f.", randomNumber);
        return false;
    }

    static void circleArea() {
        int circleRadius = new Random().nextInt(100);//(int)RandomMath.generateRandom(0, 100);
        double circleArea = Math.PI * Math.pow(circleRadius, 2);
        System.out.printf("A circle of radius %d has an area of %.2f.", circleRadius, circleArea);
    }

    static void randomSquareArea() {
        int sideLength = (int)generateRandom(0,100);
        double squareArea = Math.pow(sideLength, 2);
        System.out.printf("A square of side length %d has an area of %.0f.", sideLength, squareArea);
    }

    //Generates random numbers through the use of Math.random()
    static double generateRandom(double lowerEnd, double upperEnd) {
        return (lowerEnd + (Math.random() * (upperEnd - lowerEnd)));
    }

}