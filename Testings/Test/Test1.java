public class Test1<T> implements Comparable<Test1> {
    private String flavor;
    private double sweetness;
    

    Test1(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
        System.out.println("Completed1");
    }





    public int compareTo(Test1 other) {
        System.out.println(this.flavor);
        System.out.println(this.sweetness);
        System.out.println(other.flavor);
        System.out.println(other.sweetness);
        
        if (other instanceof Test3) {
            Test3 that = (Test3) other;
            System.out.println(that.skibidi);
        }

        System.out.println("Completed2");
        return 0;
    }
}