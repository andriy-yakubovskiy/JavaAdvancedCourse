/*
Create a file, write some arbitrary data to file, and close the file.
Then open this file again, read data from it and print it to the console.
Type its data and print it to the console.
*/
package task03_02;

import java.io.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        File directory = new File("");
        String myPath = directory.getAbsolutePath();
        String newFilePath = myPath + "\\TEST.txt";

        File myFile = new File(newFilePath);
        if (!myFile.exists()) {
            try {
                if (!myFile.createNewFile()) {
                    exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
                exit(0);
            }
        }

        String textFromConsole = textReaderFromConsole();
        textWriterToFile(myFile, textFromConsole);

        String textFromFile = textReaderFromFile(myFile);
        textWriterToConsole(textFromFile);

    }

    public static String textReaderFromFile(File myFile) {
        String scanText = new String("");
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader((new FileInputStream(myFile))))) {
            String strText;
            while ((strText = bReader.readLine()) != null) {
                scanText = scanText.concat(strText).concat("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return scanText;
    }

    public static void textWriterToConsole(String myText) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        writer.print(myText);
        writer.close();
    }

    public static String textReaderFromConsole() {
        String scanText = new String("");
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            String strText;
            while (!((strText = bReader.readLine()).equals("EXIT"))) {
                scanText = scanText.concat(strText).concat("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return scanText;
    }

    public static void textWriterToFile(File myFile, String myText) {
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myFile)), true)) {
            writer.print(myText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}