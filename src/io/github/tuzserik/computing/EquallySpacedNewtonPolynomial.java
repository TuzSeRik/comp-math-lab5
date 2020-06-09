package io.github.tuzserik.computing;

public class EquallySpacedNewtonPolynomial extends NewtonPolynomial{
    public EquallySpacedNewtonPolynomial(double[] xArray, double[] yArray, double argument) {
        super(xArray, yArray, argument);
    }

    @Override
    public String calculateSolution() {
        double y;
        if (findFirstNode() > xArray.length / 2) {
            y = backwardInterpolation();
        }
        else {
            y = forwardInterpolation();
        }

        return "Приближенное значение функции y=f(x): " + y;
    }

    @Override
    public int findFirstNode () {
        if (argument < xArray[1]) {
            return 0;
        }

        return xArray.length - 1;
    }

    private double forwardInterpolation() {
        int index = findFirstNode();
        int degree = yArray.length - (index + 1);
        double y = yArray[index];
        double t = (argument - xArray[index]) / h;

        System.out.println("Интерполирование вперед");

        while (degree > 0) {
            y += calculateDelta(index, degree) * (tPartDescend(t, degree - 1) / factorial(degree));

            degree--;
        }

        return y;
    }

    private double backwardInterpolation() {
        int index = findFirstNode();
        int degree = index;
        int i = 0;
        double y = yArray[index];
        double t = (argument - xArray[index]) / h;

        System.out.println("Интерполирование назад");

        while (degree > 0) {
            y += calculateDelta(i++, degree) * (tPartAscend(t, degree - 1) / factorial(degree));

            degree--;
        }

        return y;
    }

    private double calculateDelta(int yIndex, int degree){
        if (degree > 0) return calculateDelta(yIndex + 1, degree - 1)
                - calculateDelta(yIndex , degree - 1);

        return yArray[yIndex];
    }

    private int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    private double tPartDescend(double t, int i) {
        double q = t;
        while (i > 0) {
            q *= t - i;
            i --;
        }

        return q;
    }

    private double tPartAscend(double t, int i) {
        double q = t;
        while (i > 0) {
            q *= t + i;
            i --;
        }

        return q;
    }
}
