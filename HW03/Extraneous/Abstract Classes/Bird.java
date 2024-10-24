public abstract class Bird extends Animal {

    public Bird() { // Is this constructor useful when the class is abstract?
        super("Bird");
    }
    public Bird(String s) { super(s); }
    
    public abstract void makeNoise();
    
    // We can "force" concrete methods from ancestors 
    // to be overridden by making abstract in a subclass
    public abstract void scratch(int times);
    
    public String toString() {
        return "this Bird is a " + species;
    }
}
