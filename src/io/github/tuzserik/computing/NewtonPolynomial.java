package io.github.tuzserik.computing;

public abstract class NewtonPolynomial extends Polynomial{
    protected double h;

    protected NewtonPolynomial(double[] xArray, double[] yArray, double argument) {
        super(xArray, yArray, argument);
        h = xArray[1] - xArray[0];
    }

    abstract protected int findFirstNode();
}
