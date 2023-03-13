/*
Create an Animal class
Describe 3 different fields in it, create a constructor, methods.
Create a file and serialize the Animal object.
*/
package task07;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File directory = new File("");
        String globalLinkPath = directory.getAbsolutePath();
        String linkFilePath = globalLinkPath + "\\TEST.txt";

        File myFile = new File(linkFilePath);

        Animal animal = new Animal("Dog", "Djem", 1, 315450);
        System.out.println(animal.getType() + ", " + animal.getName() + ", " + animal.getAge() + ", " + animal.get_ID());

        //serialization
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(myFile))) {
            outputStream.writeObject(animal);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //deserialization
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(myFile))) {
            Animal deSerAnimal = (Animal) inputStream.readObject();
            System.out.println(deSerAnimal.getType() + ", " + deSerAnimal.getName() + ", " + deSerAnimal.getAge() + ", " + deSerAnimal.get_ID());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}