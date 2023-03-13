package task09;

public class OtherClass1 extends Thread {
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("start-DaemonThread");
                sleep(1000);
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("start-NormThread");
                sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.print("Error" + e);
        } finally {
            if (!isDaemon()) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("end-NormThread");
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("end-DaemonThread");
            }
        }
    }
}