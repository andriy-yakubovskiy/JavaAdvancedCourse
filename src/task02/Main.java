/*
Enter strings from the keyboard until the user types the string 'end':
1. Create a list of strings.
2. Enter strings from the keyboard and add them to the list.
3. Enter strings from the keyboard until the user enters the string "end". "end" is ignored.
4. Display the lines on the screen, each on a new line.
*/
package task02;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String value = "";
            while (!value.equals("end")) {
                System.out.println("Enter data: ");
                value = reader.readLine();
                myList.add(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (String tmp : myList) {
                writer.write(tmp + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}