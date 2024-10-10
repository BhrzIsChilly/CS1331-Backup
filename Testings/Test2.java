public class Test2 {
    public static String formatLength(Double length) {
        double unwrappedLength = length.doubleValue();
        int lengthFeet = (int) unwrappedLength;
        double lengthInches = (unwrappedLength - lengthFeet) * 12;

        // String formattedLengthToString = String.format("%d ft %.2f in", lengthFeet, lengthInches);
        return (String.format("%d ft %.2g in", lengthFeet, lengthInches));
    }

    public static void main(String[] args) {
        Double doubleValue = 3.999;
        String strung = formatLength(doubleValue);
        System.out.println(strung);
    }
}