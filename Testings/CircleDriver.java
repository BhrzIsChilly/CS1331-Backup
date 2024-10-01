public class CircleDriver {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();

        // c1.radius = 12;
        System.out.println("Circle c1: " + c1);
        c1.setRadius(99);
        System.out.println("Circle c1: " + c1);
        // c2.radius = 7;
        System.out.println("Circle c2: " + c2);
        c2.setRadius(12);
        System.out.println("Circle c2: " + c2);

        System.out.println("c1's radius is: " + c1.getRadius());
    }
}