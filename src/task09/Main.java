package task09;

public class Main {

    public static void main(String[] args) {
        OtherClass1 norm = new OtherClass1();
        OtherClass1 daem = new OtherClass1();

        Thread normThread = new Thread(norm);

        daem.setDaemon(true);

        normThread.start();
        daem.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        System.out.println("\nEND\n");
        System.exit(0);
    }
}