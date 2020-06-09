package io.github.tuzserik.inputting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

public abstract class Broker {
    protected BufferedReader in;
    protected BufferedWriter out;

    Broker(BufferedReader in, BufferedWriter out) {
        this.in = in;
        this.out = out;
    }

    public abstract ArrayList<ArrayList<Double>> readData();

    public abstract void writeData(String answer);

    public double[] convertArray(ArrayList<Double> array) {
        double[] convertedArray = new double[array.size()];

        for (int i = 0; i < array.size(); i++) {
            convertedArray[i] = array.get(i);
        }

        return convertedArray;
    }
}
