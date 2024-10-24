public class Dog extends Animal {
    // think of this as a regular class with some "mandatory" methods to override

    private int numLegs;

    public Dog() {
        super("Doggo");
        this.numLegs = 1;
    }

    @Override
    public void makeNoise() { // do we need to provide this implementation?
        System.out.println("woof woof");
    }

    public void bark() { // define new methods like any other class
        System.out.println("arf arf");
    }

    @Override
    public void scratch(int howLong) { // what if we delete this method? Does it compile?
        for (int i = 0; i < howLong; i++) {
            System.out.println("instead of scratching, doggo licks you, +5hp");
        }
    }

    @Override
    public String toString() {
        return "The bestest boy";
    }

}
