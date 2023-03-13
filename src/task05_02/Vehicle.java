package task05_02;

public class Vehicle {
    private String species;
    private String engine;
    private int speed;

    public Vehicle(String species, String engine, int speed) {
        this.species = species;
        this.engine = engine;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "species='" + species + '\'' +
                ", engine='" + engine + '\'' +
                ", speed=" + speed +
                '}';
    }

    private void Move() {
        speed = 200;
    }

}