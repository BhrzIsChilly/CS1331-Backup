public class CircleDriver {
    
    public static void main(String[] args) {
        
        Circle c1 = new Circle(99);
        //c1.setRadius(99);
        System.out.println("Circle c1: " + c1);
        
        Circle c2 = new Circle(111);
        //c2.setRadius(111);
        System.out.println("Circle c2: " + c2);
        
        Circle c3 = new Circle(-100);
        //c3.setRadius(-100);
        System.out.println("Circle c3: " + c3);
        
        Circle c4 = new Circle(0);
        //c4.setRadius(0);
        System.out.println("Circle c4: " + c4);
        
        Circle c5 = new Circle(10, "uranussy blue");
        //c5.setRadius(0);
        System.out.println("Circle c5: " + c5);
        
        System.out.printf("\n%s=\n\n","=~".repeat(32));
        
        Circle c6 = new Circle(12, "purple idgaf", 8, 31);
        //c6.setRadius(0);
        System.out.println("Circle c6: " + c6);
        
        Circle copyC6 = new Circle(c6);
        System.out.println("Circle copyC6: " + copyC6);
        
        c6.setCoords(66,77);
        System.out.println("Circle c6: " + c6);
        System.out.println("Circle copyC6: " + copyC6); 
        
    }   
}