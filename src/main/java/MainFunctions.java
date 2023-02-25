public class MainFunctions {

    private static final double Y = 10000;
    private static final double n = 0.1;


    //x'
    public static double f1(double y1, double y2) {
        return ((1-y1)* Math.pow(y1, 2)) / (n + y1) - y1 * y2;
    }

    //0'
    public static double f2(double m, double y1, double y2) {
        return Y * (y1 - m) * y2;
    }
}
