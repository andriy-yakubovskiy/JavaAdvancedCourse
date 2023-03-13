/*
Create a text file and a class in 'package', add some text to the file.
Display the contents of the file on the screen.
*/
package task03;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File directory = new File("");
        String myPath = directory.getAbsolutePath();

        String newFilePath = myPath + "\\MainTEST.txt";
        String classFilePath = myPath + "\\src\\task03\\Main.java";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(classFilePath))));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(newFilePath))), true)) {

            reader.mark(10000);

            //read stream and writer file
            int i;
            while ((i = reader.read()) != -1) {
                writer.print((char) i);
            }

            //output to console
            reader.reset();
            String str = reader.readLine();
            while (str != null) {
                System.out.println(str);
                str = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}