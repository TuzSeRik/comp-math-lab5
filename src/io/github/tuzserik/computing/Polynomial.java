package io.github.tuzserik.computing;

public abstract class Polynomial {
    protected double[] xArray;
    protected double[] yArray;
    protected double argument;

    protected Polynomial(double[] xArray, double[] yArray, double argument) {
        this.xArray = xArray;
        this.yArray = yArray;
        this.argument = argument;
    }

    public abstract String calculateSolution();
}
