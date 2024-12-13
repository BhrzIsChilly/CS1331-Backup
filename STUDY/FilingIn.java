import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilingIn {
    private static int[] arrayIn = new int[10];
    private static String inputString;

    public static void main(String[] args) {
        File fileIn = new File("./FileIn.csv");
        File fileOut = new File("./FileOut.csv");

        try {
            PrintWriter output = new PrintWriter(fileOut);
            Scanner input = new Scanner(fileIn);

            while (input.hasNext()) {
                inputString = input.nextLine();
                System.out.println(inputString);
            }

            output.println(inputString);
            output.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }


    }

}
