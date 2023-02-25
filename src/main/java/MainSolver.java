import java.io.IOException;
import java.util.Arrays;

public class MainSolver {

    private static final double a = 0;
    private static final double b = 1000;
    private static final int n = 10000;
    private static final double h = (b - a) / n;

    public static void solve(double m) throws IOException {
        double[] y1 = new double[n];
        double[] y2 = new double[n];
        double[] x = new double[n];
        y1[0] = 0.3;
        y2[0] = 0.3;

        for (int i = 0; i < n; i++) {
            double t = a + i * h;
            x[i] = t;

            double k1 = MainFunctions.f1(y1[i], y2[i]);
            double m1 = MainFunctions.f2(m, y1[i], y2[i]);

            double k2 = MainFunctions.f1(y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);
            double m2 = MainFunctions.f2(m, y1[i] + h * k1 / 2, y2[i] + h * m1 / 2);

            double k3 = MainFunctions.f1(y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);
            double m3 = MainFunctions.f2(m, y1[i] + h * k2 / 2, y2[i] + h * m2 / 2);

            double k4 = MainFunctions.f1(y1[i] + h * k3, y2[i] + h * m3);
            double m4 = MainFunctions.f2(m, y1[i] + h * k3, y2[i] + h * m3);

            if (i != n - 1) {
                y1[i + 1] = y1[i] + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6;
                y2[i + 1] = y2[i] + h * (m1 + 2 * m2 + 2 * m3 + m4) / 6;
            }
        }

        Arrays.stream(y2)
                        .forEach(System.out::println);

        XLSXHelper.writeTablesMain(x, y1, y2, "main");
    }
}
