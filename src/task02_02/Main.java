/*
Using the collection, double the word:
1. Enter 5 words from the keyboard into the List of strings.
2. The 'doubleValues' method should double words according to the principle a,b,c -> a,a,b,b,c,c.
3. Using the For loop, display the result on the screen, each value on a new line.
*/
package task02_02;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    public static <T> T addListString() {
        List<T> arr = new ArrayList<>();

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = System.out;
        Writer outputStreamReader = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);

        try {
            while (arr.size() < 10) {
                bufferedWriter.write("Enter:");
                bufferedWriter.flush();

                String textFromUser = null;
                try {
                    textFromUser = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Error in enter!!!");
                    exit(0);
                }
                arr.add((T) textFromUser);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (T) arr;
    }

    public static void doubleValues(List<String> arrList) {

        //for (String str : arrList) {
        ListIterator<String> strIterator = arrList.listIterator();
        while (strIterator.hasNext()) {
            String str = strIterator.next();

            char[] charList = str.toCharArray();
            List<Character> newCharList = new LinkedList<>();
            for (int i = 0; i < charList.length; i++) {
                newCharList.add(charList[i]);
                newCharList.add(charList[i]);
            }
            strIterator.set(newCharList.toString());
        }

    }

    public static void main(String[] args) {

        //list
        List<String> arrList = addListString();

        //change list
        if (!arrList.isEmpty()) {
            doubleValues(arrList);
        }

        //out changed list
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }

    }

}