package task05_02;

public class Road {
    private String kind;
    private byte width;
    private int length;

    public Road(String kind, byte width, int length) {
        this.kind = kind;
        this.width = width;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "kind='" + kind + '\'' +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}