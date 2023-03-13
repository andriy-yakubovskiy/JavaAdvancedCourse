package task05_02;

public class House {
    private String type;
    private byte numberOfStoreys;
    private int size;

    public House(String type, byte numberOfStoreys, int size) {
        this.type = type;
        this.numberOfStoreys = numberOfStoreys;
        this.size = size;
    }

    @Override
    public String toString() {
        return "House{" +
                "type='" + type + '\'' +
                ", numberOfStoreys=" + numberOfStoreys +
                ", size=" + size +
                '}';
    }
}