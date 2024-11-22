public class Shape {
    protected static final String DEF_COLOR = "BLACK";
    protected static final int DEF_X = 0;
    protected static final int DEF_Y = 0;
    
    private String color;
    private int[] coords = new int[2];
    
    protected Shape() {
        this(DEF_COLOR, DEF_X, DEF_Y);
    }
    
    // probably shouldn't be public since it "doesn't make sense" to create a "shape"
    public Shape(String color, int x, int y) { 
        setColor(color);
        setCoords(x, y);
    }
    
    protected Shape(Shape toCopy) {
        if(toCopy != null) {
            this.color = toCopy.color;
            this.coords[0] = toCopy.coords[0];
            this.coords[1] = toCopy.coords[1];
        }
    }
    
    public void setColor(String c) {
        this.color = (color == null || color.isBlank()) 
                        ? DEF_COLOR 
                        : color.toUpperCase();
    }
    
    public String getColor() {
        return color;
    }    
    
    public int getX() {
        return coords[0];
    }
    
    public int getY() {
        return coords[1];
    }
    
    public void setCoords(int x, int y) {
        coords[0] = (x > 0) ? x : 0;
        coords[1] = (y > 0) ? y : 0;
    }
    
    public double area() { // area of a "shape" doesn't make sense, so return -1
        return -1;
    }
    
    public double perimeter() { // perimeter of a "shape" doesn't make sense, so return -1
        return -1;
    }
    
    public String toString() {
        return String.format("<x,y,color : %d,%d,%s>", 
                                getX(),getY(),color);
    }
}