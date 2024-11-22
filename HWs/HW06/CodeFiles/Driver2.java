import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver2 {
    public static void main(String[] args) {


        // BasketballGame hawks = new BasketballGame(venue, startTime, startDate, score1, score2, seatsLeft, league);
        // BasketballGame basketball = new BasketballGame(venue, startTime, startDate, score1-1, score2, seatsLeft, league2);

        // ArrayList<SportsGame> abc = new ArrayList<>();
        // abc.add(hawks);
        // abc.add(basketball);
        // // System.out.printf("%s", basketball.equals(hawks) ? "y" : "n");
        // // System.out.printf("%s", basketball.equals(basketball) ? "y" : "n");
        // // System.out.printf("%s", hawks.equals(hawks) ? "y" : "n");
        // // System.out.printf("%s", hawks.equals(basketball) ? "y" : "n");
        // // System.out.println(hawks.toString());



        String venue = "State Farm";
        String startTime = "7:00";
        String startDate = "10/20/2025";
        int score1 = 102;
        int score2 = 48;
        int seatsLeft = 3;
        String league = "AAA Division";
        String league2 = "AA Division";
        String league3 = "B Division";
        String performer = "Buzz";
        String performer2 = "Buzzette";

        BasketballGame gameB1 = new BasketballGame(venue, startTime, startDate, score1, score2, seatsLeft, league);
        BasketballGame gameB2 = new BasketballGame(venue, startTime, startDate, score1, score2, seatsLeft, league2);
        FootballGame gameF1 = new FootballGame(venue, startTime, startDate, score1, score2, seatsLeft, performer);
        FootballGame gameF2 = new FootballGame(venue, startTime, startDate, score1, score2, seatsLeft, performer2);
        BasketballGame gameB3 = new BasketballGame(venue, startTime, startDate, score1, score2, seatsLeft, league3);
        

        ArrayList<SportsGame> abc = new ArrayList<>();
        abc.add(gameB1);
        abc.add(gameB2);
        abc.add(gameF1);
        abc.add(gameF2);

        String filePath = "/home/bhrz/Documents/Scripts/Java/CS1331-Backup/HWs/HW06/CodeFiles/TestTickets.csv";

        try {

            Ticket.purchaseTickets(filePath, abc);

            abc.add(gameB3);

            Ticket.purchaseTickets(filePath, abc);

            ArrayList<SportsGame> def = Ticket.retrieveGames(filePath);

            for (SportsGame i: def) {
                System.out.println(i);
            }

            Ticket.attendGame(filePath, gameF2);



        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (InvalidTicketException ite) {
            System.out.println(ite.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } 





    }
}