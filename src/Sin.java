public class Sin {
    static double sin(double x) {
        double result = 0;
        for (int n = 1; n < 7; n++) {
            result += Math.pow(-1, n-1) * Math.pow(x, 2 * n-1) / factorial(2 * n-1);
        }

        return result;
    }

    private static int factorial(int x) {
        if (x <= 1)
            return 1;
        else
            return x * (factorial(x - 1));

    }
}
