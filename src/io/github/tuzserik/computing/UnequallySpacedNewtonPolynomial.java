package io.github.tuzserik.computing;

public class UnequallySpacedNewtonPolynomial extends NewtonPolynomial{
    public UnequallySpacedNewtonPolynomial(double[] xArray, double[] yArray, double argument) {
        super(xArray, yArray, argument);
    }

    @Override
    public String calculateSolution() {
        int x0Index = findFirstNode();
        double y;

        double fX0X1 = (yArray[x0Index + 1] - yArray[x0Index]) / (xArray[x0Index + 1] - xArray[x0Index]);
        double fX1X2 = (yArray[x0Index + 2] - yArray[x0Index + 1]) / (xArray[x0Index + 2] - xArray[x0Index + 1]);
        double fX0X1X2 = (fX1X2 - fX0X1) / (xArray[x0Index + 2] - xArray[x0Index]);

        y = yArray[x0Index] + fX0X1 * (argument - xArray[x0Index]) + fX0X1X2 * (argument - xArray[x0Index]) * (argument - xArray[x0Index + 1]);

        return "Приближенное значение функции y=f(x): " + y;
    }

    @Override
    protected int findFirstNode() {
        int x0Index = 0;

        if (argument < xArray[1]) {
            return 1;
        }

        if (argument > xArray[xArray.length - 1]) {
            return xArray.length - 3;
        }

        for (int i = 0; i < xArray.length; i++) {
            if (argument < xArray[i]) {
                x0Index = i - 1;
                break;
            }
        }

        int rem = xArray.length - (x0Index + 1);
        x0Index = (rem == 1)? (x0Index -1) : x0Index;

        return x0Index;
    }
}
