/*public class Test3 implements Test2 {
    public void method2() {
        System.out.println("Method 2 called.");
    }

    public void method1() {
        System.out.println("Method 1.2 called.");
    }


    public static void main(String[] args) {
        Test3 test = new Test3();

        test.method1();
        test.method2();

    }
} */

public class Test3 extends Test2 {
    public void method2() {
        System.out.println("Method 2 called.");
    }

    public static void main(String[] args) {
        Test3 test = new Test3();

        test.method1();
        test.method2();

    }
}

