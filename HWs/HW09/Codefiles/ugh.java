public class ugh {
    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int c = 'c';
        int[] d = new int[5];
        int[][] e = {{1,2,3}, {1,2}, {1}, {'a', 'b', 'c'}};
        int[][] f = new int[2][1] {{1}, {2}};
        System.out.println(ineq(a, b));
        System.out.println(c);
    }

    public static boolean ineq(double a, int b) {
        return a > b;
    }

}