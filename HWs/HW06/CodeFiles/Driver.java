import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        try {
            // Step 1: Create two BasketballGame and two FootballGame objects
            BasketballGame basketballGame1 = new BasketballGame("Arena A", "18:00", "2024-11-10", 102, 98, 50, "NBA");
            BasketballGame basketballGame2 = new BasketballGame("Arena B", "20:00", "2024-11-11", 110, 105, 30, "NBA");
            FootballGame footballGame1 = new FootballGame("Stadium X", "14:00", "2024-11-12", 21, 17, 25, "TeamX vs TeamY");
            FootballGame footballGame2 = new FootballGame("Stadium Y", "16:00", "2024-11-13", 24, 20, 0, "TeamA vs TeamB");

            // Step 2: Add these games to a file using purchaseTickets
            ArrayList<SportsGame> games = new ArrayList<>();
            games.add(basketballGame1);
            games.add(basketballGame2);
            games.add(footballGame1);
            games.add(footballGame2);
            Ticket.purchaseTickets("TestTickets.csv", games);
            System.out.println("Initial games added to TestTickets.csv.");

            // Step 3: Create another BasketballGame object and add it to the file
            BasketballGame basketballGame3 = new BasketballGame("Arena C", "19:00", "2024-11-14", 95, 100, 20, "NBA");
            ArrayList<SportsGame> additionalGames = new ArrayList<>();
            additionalGames.add(basketballGame3);
            Ticket.purchaseTickets("TestTickets.csv", additionalGames);
            System.out.println("Additional BasketballGame added to TestTickets.csv.");

            // Step 4: Read the CSV file and print each object to a new line
            ArrayList<SportsGame> retrievedGames = Ticket.retrieveGames("TestTickets.csv");
            System.out.println("Games in TestTickets.csv after additions:");
            for (SportsGame game : retrievedGames) {
                System.out.println(game);
            }



            // Step 5: Call attendGame on one of the BasketballGame objects
            Ticket.attendGame("TestTickets.csv", basketballGame1);
            System.out.println("BasketballGame1 attended and removed from TestTickets.csv.");

            // Step 6: Verify removal by printing games in CSV file
            ArrayList<SportsGame> gamesAfterAttendance = Ticket.retrieveGames("TestTickets.csv");
            System.out.println("Games in TestTickets.csv after attending BasketballGame1:");
            for (SportsGame game : gamesAfterAttendance) {
                System.out.println(game);
            }

            // Additional Test Cases
            // Test case: Attempt to retrieve games from a non-existent file
            try {
                ArrayList<SportsGame> nonExistentFileGames = Ticket.retrieveGames("NonExistentFile.csv");
            } catch (FileNotFoundException e) {
                System.out.println("Caught FileNotFoundException as expected for a non-existent file.");
            }

            // Test case: Attempt to add a game with no seats left and check it's not added
            FootballGame footballGameNoSeats = new FootballGame("Stadium Z", "18:00", "2024-11-15", 28, 14, 0, "TeamC vs TeamD");
            ArrayList<SportsGame> noSeatsGames = new ArrayList<>();
            noSeatsGames.add(footballGameNoSeats);
            Ticket.purchaseTickets("TestTickets.csv", noSeatsGames);
            ArrayList<SportsGame> gamesAfterNoSeatsTest = Ticket.retrieveGames("TestTickets.csv");
            System.out.println("Games in TestTickets.csv after attempting to add a FootballGame with no seats left:");
            for (SportsGame game : gamesAfterNoSeatsTest) {
                System.out.println(game);
            }

            // Test case: Attempt to find tickets by providing matching games
            ArrayList<Integer> foundIndexes = Ticket.findTickets("TestTickets.csv", basketballGame2);
            System.out.println("Found matching game indexes for basketballGame2:");
            for (Integer index : foundIndexes) {
                System.out.println("Index: " + index);
            }

            // Test case: Attempt to find tickets by providing matching games
            ArrayList<Integer> foundIndexes2 = Ticket.findTickets("TestTickets.csv", footballGame1);
            System.out.println("Found matching game indexes for footballGame1:");
            for (Integer index : foundIndexes2) {
                System.out.println("Index: " + index);
            }

            // Test case: Attempt to attend a game not present in the file
            BasketballGame nonExistentGame = new BasketballGame("Arena D", "20:00", "2024-11-16", 99, 101, 10, "NBA");
            try {
                Ticket.attendGame("TestTickets.csv", nonExistentGame);
            } catch (InvalidTicketException e) {
                System.out.println("Caught InvalidTicketException as expected for a game not in file.");
            }



        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}