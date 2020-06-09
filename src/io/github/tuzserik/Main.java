package io.github.tuzserik;

import io.github.tuzserik.computing.LagrangePolynomial;
import io.github.tuzserik.computing.NewtonPolynomialSelector;
import io.github.tuzserik.computing.Polynomial;
import io.github.tuzserik.inputting.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Broker currentBroker = null;
        Polynomial currentPolynomial = null;

        try {
            out.write("Для работы с консолью введите \"1\".\n\n");

            out.write("Для работы с файлом введите \"2\".\n"
                    + "В файле в качестве разделителя должны быть использованы пробелы.\n\n");
            out.flush();

            switch (in.readLine()) {
                case "1":
                    currentBroker = new ConsoleBroker(in, out);
                    break;
                case "2":
                    currentBroker = new FileBroker(in, out);
                    break;
            }

            assert currentBroker != null;
            ArrayList<ArrayList<Double>> temp = currentBroker.readData();
            out.write("Введите приближение.\n\n");
            out.flush();
            double argument = Double.parseDouble(in.readLine());

            out.write("Для выбора метода Лагранжа введите \"1\".\n\n");

            out.write("Для выбора метода Ньютона введите \"2\".\n");

            out.flush();

            switch (in.readLine()) {
                case "1":
                    currentPolynomial = new LagrangePolynomial(currentBroker.convertArray(temp.get(0)),
                            currentBroker.convertArray(temp.get(1)), argument);
                    break;
                case "2":
                    currentPolynomial = new NewtonPolynomialSelector(currentBroker.convertArray(temp.get(0)),
                            currentBroker.convertArray(temp.get(1)), argument);
                    break;
            }

            assert currentPolynomial != null;
            out.write(currentPolynomial.calculateSolution());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка потока данных!\nПроверьте, скорее всего вы ввели неправильные данные.");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Вы не ввели данные, необходимые для старта программы!\nПовторите попытку ввода.");
        }
    }
}
