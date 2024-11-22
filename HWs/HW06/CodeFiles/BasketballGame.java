/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class BasketballGame extends SportsGame {
    // Variables
    private String league;


    // Constructors
    /**
     * @param venue the venue the game is at
     * @param startTime the time the game starts
     * @param startDate the date the game starts
     * @param score1 the score of team1
     * @param score2 the score of team2
     * @param seatsLeft the amount of seats left in the venue
     * @param league the league the teams are competing in
     */
    public BasketballGame(String venue, String startTime, String startDate,
                    int score1, int score2, int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        try {
            if (SportsGame.isNullOrEmpty(league)) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        league = league.trim();

        this.league = league;
    }


    // Methods
    /**
     * @return returns csv of all values of BasketballGame
     */
    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), this.league);
    }

    /**
     * @return returns if the instantiated object is equal to the argumented object.
     * @param other the parameterized object to be argumented.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof BasketballGame) {
            BasketballGame that = (BasketballGame) other;

            if (super.equals(that) && this.league.equals(that.league)) {
                return true;
            }
        }

        return false;
    }

}