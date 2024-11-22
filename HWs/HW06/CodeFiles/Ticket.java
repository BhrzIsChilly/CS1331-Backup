import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Ticket {
    // Methods
    // Retrieve info in the form of SportsGame objects from a .csv file.
    /**
     * @return returns an ArrayList of SportsGame's from a csv file
     * @param retrievableFilePath the path to the file being read from.
     */
    public static ArrayList<SportsGame> retrieveGames(String retrievableFilePath)
                            throws FileNotFoundException, InvalidTicketException {
        if (SportsGame.isNullOrEmpty(retrievableFilePath)) {
            throw new FileNotFoundException();
        }

        File filePath = new File(retrievableFilePath);
        ArrayList<SportsGame> fileInducedGames = new ArrayList<>();

        if (filePath.exists() && !filePath.isDirectory()) { // Will assume file is readable
            Scanner fileReader = new Scanner(filePath);
            while (fileReader.hasNextLine()) {
                String sportsGameData = fileReader.nextLine();
                fileInducedGames.add(processInfo(sportsGameData));
                // System.out.println(fileInducedGames); // %debug
            }
        } else {
            throw new FileNotFoundException();
        }

        return fileInducedGames;
    }


    // Helper Method
    // Process Info
    /**
     * @return returns a SportsGame object from a String of CSVs.
     * @param sportsGameData the String of CSVs.
     */
    private static SportsGame processInfo(String sportsGameData) throws InvalidTicketException {
        SportsGame interimTokenConversion;
        String[] dataTokens = sportsGameData.split(",");

        if (dataTokens[0].equals("BasketballGame")) {
            interimTokenConversion = new BasketballGame(dataTokens[1], dataTokens[2], dataTokens[3],
                                    Integer.parseInt(dataTokens[4]), Integer.parseInt(dataTokens[5]),
                                    Integer.parseInt(dataTokens[6]), dataTokens[7]);
        } else if (dataTokens[0].equals("FootballGame")) {
            interimTokenConversion = new FootballGame(dataTokens[1], dataTokens[2], dataTokens[3],
                                    Integer.parseInt(dataTokens[4]), Integer.parseInt(dataTokens[5]),
                                    Integer.parseInt(dataTokens[6]), dataTokens[7]);
        } else {
            throw new InvalidTicketException(
                String.format("%s is not a valid game ticket in our systems.",
                                dataTokens[0])); // Looks ugly as heck. Checkstyle to tell you :)
        }

        // System.out.println(interimTokenConversion); // %debug
        return interimTokenConversion;
    }


    // Purchase Tickets
    /**
     * @param writableFilePath the path to the file being written to.
     * @param sportsGames a list of SportsGame's to attempt to add to the .csv file.
     */
    public static void purchaseTickets(String writableFilePath, ArrayList<SportsGame> sportsGames)
        throws IllegalArgumentException, FileNotFoundException, InvalidTicketException {
        if (SportsGame.isNullOrEmpty(writableFilePath)) {
            throw new IllegalArgumentException();
        }

        File filePath = new File(writableFilePath);
        FileWriter writeToFile;

        try {
            filePath.createNewFile();
            writeToFile = new FileWriter(filePath, true);

            for (SportsGame i : sportsGames) {
                boolean canWriteToFile = true;
                if (i.getSeatsLeft() > 0) {
                    for (SportsGame j : retrieveGames(writableFilePath)) { // May assume its readable;
                        if (i.equals(j)) {
                            canWriteToFile = false;
                        }
                    }

                    if (canWriteToFile) {
                        writeToFile.write(String.format("%s\n", i.toString()));
                    }
                }
            }

            writeToFile.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }


    // Find Tickets
    /**
     * @return returns indexes of where found tickets are located in the csv file by line indexing.
     * @param readablePathFile the path to the file being read from.
     * @param findingGame the game to find inside the csv file.
     */
    public static ArrayList<Integer> findTickets(String readablePathFile, SportsGame findingGame)
        throws FileNotFoundException, InvalidTicketException {
        ArrayList<SportsGame> gameList = Ticket.retrieveGames(readablePathFile);
                // The index of each SportsGame is concurrent
                // with the line the game is found in the CSV file.
        ArrayList<Integer> gameIndexes = new ArrayList<>();
        boolean gameFound = false;
        for (int i = 0; i < gameList.size(); i++) {
            if (findingGame.equals(gameList.get(i))) {
                gameIndexes.add(i);
                gameFound = true;
            }
        }

        if (!gameFound) {
            throw new InvalidTicketException(String.format("%s not found among purchased tickets.",
                        findingGame.getClass().getSimpleName()));
        }

        return gameIndexes;
    }


    /**
     * @param writableFilePath the path to the file being written to.
     * @param attendedGame a game to remove from the csv file.
     */
    public static void attendGame(String writableFilePath, SportsGame attendedGame)
        throws FileNotFoundException, InvalidTicketException {
        ArrayList<Integer> attendedGameIndexes = Ticket.findTickets(writableFilePath, attendedGame);
        boolean gameFound = false;

        ArrayList<SportsGame> listOfSportsGames = Ticket.retrieveGames(writableFilePath);

        for (Integer i : attendedGameIndexes) {
            listOfSportsGames.remove(i.intValue());
        }

        File filePath = new File(writableFilePath);
        FileWriter writeToFile;

        try {
            writeToFile = new FileWriter(filePath);

            for (SportsGame i : listOfSportsGames) {
                writeToFile.write(String.format("%s\n", i.toString()));
            }

            writeToFile.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }


}