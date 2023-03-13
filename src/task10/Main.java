/*
Write basic Calculator using lambda expressions.
 */

package task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String operationText = "";
        double value1 = 0;
        double value2 = 0;
        double result = 0;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter value1:");
            value1 = Double.parseDouble(reader.readLine());
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter value2:");
            value2 = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter operation ('+' or '-' or '*' or '/'):");
            operationText = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Calc add = (double v1, double v2) -> v1 + v2;
        Calc addTest1 = Main::add;
        Calc addTest2 = Double::sum;

        Calc sub = (double v1, double v2) -> v1 - v2;

        Calc mul = (double v1, double v2) -> v1 * v2;

        Calc dev = (double v1, double v2) -> (v2 == 0) ? 0 : v1 / v2;

        //////////////////////////////////////////////////////////////////////

        if (operationText.equals("+")) {
            result = add.operation(value1, value2);
            System.out.println(result + " = " + value1 + "+" + value2);
            result = addTest1.operation(value1, value2);
            System.out.println(result);
            result = addTest2.operation(value1, value2);
            System.out.println(result);
        }

        if (operationText.equals("-")) {
            result = sub.operation(value1, value2);
            System.out.println(result + " = " + value1 + "-" + value2);
        }

        if (operationText.equals("*")) {
            result = mul.operation(value1, value2);
            System.out.println(result + " = " + value1 + "*" + value2);
        }

        if (operationText.equals("/")) {
            result = dev.operation(value1, value2);
            System.out.println(result + " = " + value1 + "/" + value2);
        }

    }

    public static double add(double value1, double value2) {
        return value1 + value2;
    }
}