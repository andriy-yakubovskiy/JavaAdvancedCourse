/*
RegularExpressions
Write a console application that allows the User to register under "Login",
consisting only of characters of the Latin letters, and a "Password" consisting of numbers.
*/
package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("LOG:");
            String strReg = "[A-Za-z]+";
            String strText = "";
            Pattern pat = Pattern.compile(strReg);
            Matcher mat = pat.matcher(strText);
            while (!(mat.matches())) {
                strText = bReader.readLine();
                mat = pat.matcher(strText);
            }
            System.out.println(strText);
            System.out.println("OK");

            System.out.println("PASS:");
            strReg = "[0-9]+";
            strText = "";
            pat = Pattern.compile(strReg);
            mat = pat.matcher(strText);
            while (!(mat.matches())) {
                strText = bReader.readLine();
                mat = pat.matcher(strText);
            }
            System.out.println(strText);
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
            exit(0);
        }
    }
}