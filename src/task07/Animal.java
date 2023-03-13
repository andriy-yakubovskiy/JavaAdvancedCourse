package task07;

import java.io.Serializable;

public class Animal implements Serializable {
    private String type;
    private String name;
    private int age;
    private transient int _ID;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int get_ID() {
        return _ID;
    }

    public Animal(String type, String name, int age, int _ID) {
        this.type = type;
        this.name = name;
        this.age = age;
        this._ID = _ID;
    }

    public void changeAge(int age) {
        this.age = age;
    }
}