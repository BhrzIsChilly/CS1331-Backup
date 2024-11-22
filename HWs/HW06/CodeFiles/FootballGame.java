/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class FootballGame extends SportsGame {
    // Variables
    private String performer;


    // Constructors
    /**
     * @param venue the venue the game is at
     * @param startTime the time the game starts
     * @param startDate the date the game starts
     * @param score1 the score of team1
     * @param score2 the score of team2
     * @param seatsLeft the amount of seats left in the venue
     * @param performer the performer expected to be at the game
     */
    public FootballGame(String venue, String startTime, String startDate,
                int score1, int score2, int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        try {
            if (SportsGame.isNullOrEmpty(performer)) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        performer = performer.trim();

        this.performer = performer;
    }


    // Methods
    /**
     * @return returns csv of all values of FootballGame
     */
    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), this.performer);
    }

    /**
     * @return returns if the instantiated object is equal to the argumented object.
     * @param other the parameterized object to be argumented.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof FootballGame) {
            FootballGame that = (FootballGame) other;

            if (super.equals(that) && this.performer.equals(that.performer)) {
                return true;
            }
        }

        return false;
    }
}