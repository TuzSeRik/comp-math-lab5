package io.github.tuzserik.computing;

public class NewtonPolynomialSelector extends Polynomial{
    public NewtonPolynomialSelector(double[] xArray, double[] yArray, double argument) {
        super(xArray, yArray, argument);
    }

    @Override
    public String calculateSolution() {
        boolean isEquallySpacedNodes = true;
        int i = 2;
        double h = xArray[1] - xArray[0];
        while (isEquallySpacedNodes && i < xArray.length) {
            isEquallySpacedNodes = Math.abs(xArray[i] - xArray[i - 1] - h) < 1.0e-10;
            i++;
        }

        Polynomial newtonPolynomial =
                isEquallySpacedNodes?
                        new EquallySpacedNewtonPolynomial(xArray, yArray, argument) :
                        new UnequallySpacedNewtonPolynomial(xArray, yArray, argument);

        return newtonPolynomial.calculateSolution();
    }
}
