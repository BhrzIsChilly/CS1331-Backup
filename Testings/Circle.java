public class Circle {
    private int radius;
    public static final double PIE = 3.141592;

    public void setRadius(int r) {
        // validate input (radius should be non-negative, non-zero)
        if (r < 0) {
            radius = -r; // makes r positive
        } else if (r == 0) {
            radius = 1;
        } else {
            radius = r;
        }
    }

    public int getRadius() {
        return radius;
    }

    public double area() {
        return PIE * radius * radius;
    }

    public double perimeter() {
        return 2 * PIE * radius;
    }

    public String toString() {
        return String.format("<radius,perimeter,area : %d, %.3f, %.3f>", radius, perimeter(), area());
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        c1.radius = 12;
        System.out.println("Circle c1: " + c1);
        c1.setRadius(99);
        System.out.println("Circle c1: " + c1);
        c2.radius = 7;
        System.out.println("Circle c2: " + c2);
        c2.setRadius(12);
        System.out.println("Circle c2: " + c2);


    }
}