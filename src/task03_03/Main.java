/*
It is necessary to create a line with text (take any text from the Internet).
Split this string into 2 substrings of equal length and print to the screen.
Also display each sentence on a new line.
*/
package task03_03;

import java.util.ArrayList;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        String str = "SOLID is a mnemonic acronym for five design " +
                "principles intended to make object-oriented designs more understandable, flexible, and maintainable.";

        StringBuilder myString = new StringBuilder(str);

        int lengthHalfStr = myString.length() / 2;
        if (lengthHalfStr == 0) {
            exit(0);
        }

        StringBuilder newStr1 = new StringBuilder(myString.substring(0, lengthHalfStr));
        StringBuilder newStr2 = new StringBuilder(myString.substring(lengthHalfStr));

        if (newStr1.length() > newStr2.length()) {
            newStr2 = newStr2.append(" ");
        } else if (newStr1.length() < newStr2.length()) {
            newStr1 = newStr1.append(" ");
        }

        System.out.println(newStr1);
        System.out.println(newStr2);

        ArrayList<Integer> listPoints = new ArrayList<>();
        StringBuilder strTemp = new StringBuilder(myString.toString());
        while (strTemp.indexOf(". ") != 0) {
            int indexPoint = strTemp.indexOf(". ");
            listPoints.add(indexPoint);
            strTemp = new StringBuilder(strTemp.substring(indexPoint));
        }

        if (listPoints.isEmpty()) {
            System.out.println(myString);
        } else {
            int indexPoint = listPoints.get(0);
            System.out.println(myString.substring(0, indexPoint));
            if (listPoints.size() > 1) {
                for (int i = 1; i < listPoints.size(); i++) {
                    System.out.println(myString.substring(indexPoint, listPoints.get(i)));
                    indexPoint = listPoints.get(i);
                }
            } else {
                System.out.println(myString.substring(indexPoint));
            }
        }
    }
}