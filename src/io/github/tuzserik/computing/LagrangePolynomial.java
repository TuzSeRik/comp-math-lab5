package io.github.tuzserik.computing;

public class LagrangePolynomial extends  Polynomial{
    public LagrangePolynomial(double[] xArray, double[] yArray, double argument) {
        super(xArray, yArray, argument);
    }

    @Override
    public String calculateSolution() {
        double y = 0;

        for (int i = 0; i < xArray.length; i++) {
            double l = 1;

            for (int j = 0; j < xArray.length; j++) {
                if (i != j) {
                    l *= (argument - xArray[j]) / (xArray[i] - xArray[j]);
                }
            }

            y += l * yArray[i];
        }

        return "Приближенное значение функции y=f(x): " + y;
    }
}
