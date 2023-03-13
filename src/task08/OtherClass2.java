package task08;

public class OtherClass2 extends Thread {
    private int id;

    public OtherClass2(int id) {
        this.id = id;
    }

    public synchronized void print() {
        System.out.println("id= " + id);
    }

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName());
        print();
    }
}