/*
Create 2 custom classes with fields and methods. Create two Threads.
*/
package task08;

public class Main {
    public static void main(String[] args) {
        OtherClass1 oc1 = new OtherClass1(1);
        OtherClass2 oc2 = new OtherClass2(2);

        oc1.start();
        oc2.start();
    }
}