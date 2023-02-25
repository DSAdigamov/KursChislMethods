import java.io.IOException;
import java.util.Arrays;

public class TestSolver {

    private static final double a = 0;
    private static final double b = 4;
    private static final int n = 40;
    private static final double h = (b - a) / n;

    public static void solveTest() throws IOException {
        double[] y1 = new double[n];
        double[] y2 = new double[n];
        double[] u = new double[n];
        double[] pogr = new double[n];
        double[] x = new double[n];
        double[] t_arr = new double[n];
        y1[0] = 1;
        y2[0] = 1;
        u[0] = 1;
        pogr[0] = 0;

        for (int i = 0; i < n; i++) {
            double t = a + i * h;

            double k1 = TestFunctions.f1_test(t, y1[i], y2[i]);
            double m1 = TestFunctions.f2_test(t, y1[i], y2[i]);

            double k2 = TestFunctions.f1_test(t + h / 2, y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);
            double m2 = TestFunctions.f2_test(t + h / 2, y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);

            double k3 = TestFunctions.f1_test(t + h / 2, y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);
            double m3 = TestFunctions.f2_test(t + h / 2, y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);

            double k4 = TestFunctions.f1_test(t + h, y1[i] + h * k3, y2[i] + h * m3);
            double m4 = TestFunctions.f2_test(t + h, y1[i] + h * k3, y2[i] + h * m3);

            if (i != n -1) {
                y1[i + 1] = y1[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
                y2[i + 1] = y2[i] + h * (m1 + 2 * m2 + 2 * m3 + m4) / 6;
            }

            x[i] = t;
            u[i] = Math.exp(-t);
            pogr[i] = Math.abs(y1[i] - u[i]);
        }

        double maxPogr = Arrays.stream(pogr)
                        .max().getAsDouble();

        XLSXHelper.writeTablesTest(x, y1, y2, u, pogr, "test", maxPogr);
    }


}
