import java.util.ArrayList;

/**
 * @author Braiden Anderson
 * @version 1.0.0
 */
public class Lineup<T extends Comparable<? extends Lineup>> {
    // Variables
    private ArrayList<T> lineup;
    private boolean isAscending;

    // CONSISTENT VALUES
    private static final int LINEUP_SIZE = 4;


    // Constructor
    public Lineup(T first, T second, T third, T fourth) {
        this.lineup = new ArrayList<>(LINEUP_SIZE);
        if (first != null && second != null && third != null && fourth != null) {
            this.lineup.set(0, first);
            this.lineup.set(1, second);
            this.lineup.set(2, third);
            this.lineup.set(3, fourth);
            System.out.println(this.lineup);
        }

        this.isAscending = true;
    }


    // Methods
    @Override
    public String toString() {
        return String.format("%s -> %s -> %s -> %s",
                (this.lineup.get(0) == null) ? "null" : this.lineup.get(0),
                (this.lineup.get(1) == null) ? "null" : this.lineup.get(1),
                (this.lineup.get(2) == null) ? "null" : this.lineup.get(2),
                (this.lineup.get(3) == null) ? "null" : this.lineup.get(3));
    }

    public boolean add(T element) {
        if (this.lineup.size() < LINEUP_SIZE) {
            if (isAscending) {
                for (int i = 0; i < LINEUP_SIZE; i++)
                    return true;
                for (T e : this.lineup) {
                    if (e.compareTo(element) < 0) {
                        this.lineup.set(1,e);
                    }
                }
            } else {

            }
        }
    }


    // Helper functions
    private void maintainOrder() {
        if (this.isAscending) {
            
        }
        
    }

    private boolean checkCorrectlyOrdered() {
        if (this.isAscending) {
            for (int i = 1; i < LINEUP_SIZE; i++) {
                if (this.lineup.get(i-1).compareTo(this.lineup.get(i)) > 0) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < LINEUP_SIZE; i++) {
            if (this.lineup.get(i-1).compareTo(this.lineup.get(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    private void flipOrder() {
        T temp;
        for (int i = 0; i < LINEUP_SIZE/2; i++) {
            temp = this.lineup.get(i);
            this.lineup.set(i, this.lineup.get(LINEUP_SIZE - i - 1));
            this.lineup.set(LINEUP_SIZE - i - 1, temp);
        }
    }
}