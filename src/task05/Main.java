/*
Reflection
Create 2 classes, Animal and Cat.
In the Animal class, initialize 3 different modifier fields.
In the Cat class, use reflection to access the fields of the Animal class and change the content of each of the fields.
 */
package task05;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Cat cat = new Cat("Mammals", 4, "Tom", "Tomas");
        //cat.animal
    }
}