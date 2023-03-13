/*
Min of N numbers (use 'LinkedList'):
1. Enter the number N from the keyboard.
2. Count N integers and fill the list with them - 'getIntegerList' method.
3.Find the min number among the elements of the List - the 'getMinimum' method.
*/
package task02_03;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    public static LinkedList getIntegerList(int N, BufferedWriter bufferedWriter, BufferedReader bufferedReader) {
        LinkedList<Integer> arr = new LinkedList<>();

        try {
            while (arr.size() < N) {
                bufferedWriter.write("Enter number:"+'\n');
                bufferedWriter.flush();

                Integer intFromUser = 0;
                try {
                    intFromUser = Integer.parseInt(bufferedReader.readLine());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Error in enter!!!");
                    exit(0);
                }
                arr.add(intFromUser);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    public static int getMinimum(LinkedList<Integer> arrList) {
        int min = 0;
        ListIterator<Integer> strIterator = arrList.listIterator();
        while (strIterator.hasNext()) {
            int num = strIterator.next();
            if  ((min > num) || (min==0)) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = System.out;
        Writer outputStreamReader = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);

        int N = 0;
        try {
            bufferedWriter.write("N=");
            bufferedWriter.flush();
            N = Integer.parseInt(bufferedReader.readLine());
            //bufferedWriter.write(N);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //list
        LinkedList<Integer> arrList = getIntegerList(N, bufferedWriter, bufferedReader);

        //search MIN
        if (!arrList.isEmpty()) {
            int min = getMinimum(arrList);
            System.out.println("Min: " + min);
        }

    }

}