public class BigBird extends Bird { // Can we make this abstract?
    public BigBird() {
        super("BigBird");
    }
    public void makeNoise() {
        System.out.println("TWEET TWEET!");
    }
    
    public void scratch(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("this bird is scratching you, -10hp");
        }
    }
    
}
