/* Braiden Anderson
I know y'all said to have fun with it, but I wish more people
knew that I was friendly and welcoming, and not scary despite
my larger stature and size. I love to talk with people!*/

public class TipHelper {
    public static void main(String[] args) {
        float tipPercentage = 0.15f; 
        float mealTotal = 20.179f;   
        int numberItemsOrdered = 3; 
        String customerName = "Jacob";
        float totalTip = tipPercentage * mealTotal;
        float tipTrunc = ((int)(totalTip * 100)/100.0f);
        float totalAmountPaid = tipTrunc + mealTotal;
        float totalTrunc = ((int)(totalAmountPaid * 100)/100.0f);
        System.out.println("The total tip was $" + tipTrunc);
        System.out.println(customerName + " owes a total of $" + totalTrunc);
    }
}