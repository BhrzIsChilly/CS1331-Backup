/**
 * This abstract class represents a sports game in general.
 * @author Braiden Anderson
 * @version 1.0.0
 */
public abstract class SportsGame {
    // Variables
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;


    // Constructors
    /**
     * @param venue the venue the game is at
     * @param startTime the time the game starts
     * @param startDate the date the game starts
     * @param score1 the score of team1
     * @param score2 the score of team2
     * @param seatsLeft the amount of seats left in the venue
     */
    public SportsGame(String venue, String startTime, String startDate,
                        int score1, int score2, int seatsLeft) {
        try {
            if (isNullOrEmpty(venue) || isNullOrEmpty(startTime) || isNullOrEmpty(startDate)) {
                throw new IllegalArgumentException();
            }

            if (score1 < 0 || score2 < 0 || seatsLeft < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        venue = venue.trim();
        startTime = startTime.trim();
        startDate = startDate.trim();

        this.venue = venue;
        this.startTime = startTime;
        this.startDate = startDate;
        this.score1 = score1;
        this.score2 = score2;
        this.seatsLeft = seatsLeft;
    }


    // Methods
    /**
     * @return returns csv of all values of BasketballGame
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d",
        this.venue, this.startTime, this.startDate, // Strings
        this.score1, this.score2, this.seatsLeft);  // ints
    }
    /**
     * @return returns if the instantiated object is equal to the argumented object.
     * @param other the parameterized object to be argumented.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof SportsGame) {
            SportsGame that = (SportsGame) other;

            if (this.venue.equals(that.venue) && this.startTime.equals(that.startTime)
                && this.startDate.equals(that.startDate) && this.score1 == that.score1
                && this.score2 == that.score2 && this.seatsLeft == that.seatsLeft) {
                return true;
            }
        }

        return false;
    }


    //Getter
    /**
     * @return returns int amount of seatsLeft.
     */
    public int getSeatsLeft() {
        return this.seatsLeft;
    }


    // Helper Methods
    /**
     * @return returns if a String input is null or empty.
     * @param input the String to be checked.
     */
    public static boolean isNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }
}