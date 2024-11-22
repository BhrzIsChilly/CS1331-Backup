public class Fish extends Animal {

    private boolean canSwim = true;

    public Fish() {
        super("Fisho");
    }

    @Override
    public void makeNoise() {
        System.out.println("Glug Glug");
    }
    
    @Override
    public void scratch(int d) {
        System.out.println("Fisho splashes for -0hp");
    }
}
