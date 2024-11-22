import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        ArrayList<String> vendorList = new ArrayList<>(Arrays.asList("Coke", "Coke", "Sprite", "Fanta", "Gatorade", "Monster Energy", "Italian Special"));
        ArrayList<String> vendorListPhony = new ArrayList<>(Arrays.asList("Sprite", "Fanta", "Gatorade", "Monster Energy", "Italian Special"));

        ArrayList<String> vendorListNull = null;
        ArrayList<String> vendorListEmpty = new ArrayList<>();


        VendingMachine Coke = new VendingMachine(vendorList, 20);

        try {
            Coke.checkStock(vendorList);
            Coke.checkStock(vendorListPhony);
            Coke.checkStock(vendorListEmpty);
            // Coke.checkStock(vendorListNull);
            Coke.buyItem("Monster Energy", 20);
            // Coke.buyItem(null, 20);
            Coke.buyItem("Monster Energy", 10);

        } catch(OutOfStockException oose) {
            System.out.println(oose.getMessage());
        } catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch(NotEnoughMoneyException neme) {
            System.out.println(neme.getMessage());
        }
    }
}