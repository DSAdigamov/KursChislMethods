public class TestFunctions {

    private static final double ALPHA = 2;
    private static final double BETA = 3;

    public static Double f1_test(double t, double y1, double y2) {
        return -ALPHA * y1 - BETA * y2 + (ALPHA + BETA - 1) * Math.exp(-t);
    }

    public static Double f2_test(double t, double y1, double y2) {
        return -BETA * y1 - ALPHA * y2 + (ALPHA + BETA - 1) * Math.exp(-t);
    }
}
