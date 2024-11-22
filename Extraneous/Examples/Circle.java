public class Circle {
    private int radius;
    private String color;
    public static final double PIE = 3.141592;
    private static final String DEF_COLOR = "BLACK";
    private static final int DEF_RADIUS = 1;
    
    public Circle() { // provide a no-args constructor since default goes away with Circle(int) definition
        this(DEF_RADIUS);
    }
    
    public Circle(int radius) {
        this(radius, DEF_COLOR);
    }
    
    public Circle(int radius, String color) {
        setRadius(radius);
        setColor(color);
    }
    
    public Circle(Circle toCopy) {
        if(toCopy != null) {
            this.radius = toCopy.radius;
            this.color = toCopy.color;
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = (color == null || color.isBlank()) ? DEF_COLOR : color.toUpperCase();
    }
    
    public double area() {
        return PIE * radius * radius;
    }
    
    public double perimeter() {
        return 2 * PIE * radius;
    }
    
    public String toString() {
        return String.format("<radius,perimeter,area : %d,%s,%.3f,%.3f>", radius,color,perimeter(),area());
    }
}