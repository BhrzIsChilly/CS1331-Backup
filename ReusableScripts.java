public class ReusableScripts {
    public static void main(Strings[] args) {
        System.out.printf("Yep.");
    }
    
    // methods made by me. Improved from PE03. I made a fatal mistake T)_T)
    static int generateRandom(int lowerEnd, int upperEnd) {
        return (int)(lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }

    static double generateRandom(double lowerEnd, double upperEnd) {
        return (lowerEnd + (Math.random() * (upperEnd + 1 - lowerEnd)));
    }
}