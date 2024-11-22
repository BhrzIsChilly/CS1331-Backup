public class Circle extends Shape {
    public static final double PIE = 3.141592;
    private static final int DEF_RADIUS = 1;

    private int radius;
    
    public Circle() { // provide a no-args constructor since default goes away with Circle(int) definition
        this(DEF_RADIUS);
    }
    
    public Circle(int radius) {
        this(radius, DEF_COLOR);
    }
    
    public Circle(int radius, String color) {
        this(radius, color, DEF_X, DEF_Y);
    }
    
    public Circle(int radius, String color, int x, int y) {
        super(color, x, y); // chain to Shape class's (String, int, int) constructor
        setRadius(radius);
    }
    
    public Circle(Circle toCopy) {
        super(toCopy); // chain to Shape class's copy constructor to copy Shape state info
        if(toCopy != null) {
            this.radius = toCopy.radius;
        }
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setRadius(int radius) {
        // validate input (radius should be non-negative, non-zero)
        if(radius < 0)
            this.radius = -radius; // make r positive
        else if(radius == 0)
            this.radius = DEF_RADIUS; // default radius
        else
            this.radius = radius; // provided radius is VALID
    }

    public double area() {
        return PIE * radius * radius;
    }
    
    public double perimeter() {
        return 2 * PIE * radius;
    }
    
    public String toString() {
        String shapeString = super.toString();
        int colonIndex = shapeString.indexOf(" : ");
        String leftHalf = shapeString.substring(1, colonIndex);
        String rightHalf = shapeString.substring(colonIndex,shapeString.length()-1);
        return String.format("<%s,radius,perimeter,area%s,%d,%.3f,%.3f>", 
                                leftHalf,rightHalf,radius,perimeter(),area());
    }
}