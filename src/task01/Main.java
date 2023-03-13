/*
Add logic so that method 'compareTo()' searches for
speed (if the speed of 2 objects is equal, then we search by price) -> price -> model -> color of the car.
*/
package task01;

//import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(190, 8000, "BMW", "Red");
        Car c2 = new Car(190, 2000, "Opel", "Black");
        Car c3 = new Car(185, 10000, "Mercedes", "White");
        List<Car> c = new ArrayList<>();
        c.add(c1);
        c.add(c2);
        c.add(c3);

        Collections.sort(c);
        for (Car temp : c) {
            System.out.println(temp);
        }
    }
}