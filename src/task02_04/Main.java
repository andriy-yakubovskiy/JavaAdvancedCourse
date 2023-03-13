/*
The program determines which family (Surname) lives in the City:
Input example:
• Dnipro
• Ivanovs
• Kyiv
• Petrenko
• London
• Abramovichi
-------------
• London
Sample output:
• Abramovichi
*/
package task02_04;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = System.out;
        Writer outputStreamReader = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamReader);

        bufferedWriter.write("Write four (4) Family/City:"+'\n');

        HashMap<String, String> dataListFamily = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            try {
                bufferedWriter.write("Family:");
                bufferedWriter.flush();
                String family = bufferedReader.readLine();

                bufferedWriter.write("City:");
                bufferedWriter.flush();
                String city = bufferedReader.readLine();

                dataListFamily.put(family, city);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        bufferedWriter.write("City:");
        bufferedWriter.flush();
        String cityEnter = bufferedReader.readLine();

        for (Map.Entry entry : dataListFamily.entrySet()) {
            if (cityEnter.equals(entry.getValue())) {
                System.out.println(entry.getKey());
            }
        }

//        for (Map.Entry entry : dataListFamily.entrySet())
//            System.out.println(entry.getKey() + " - " + entry.getValue());
    }
}