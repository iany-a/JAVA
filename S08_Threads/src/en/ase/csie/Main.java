package en.ase.csie;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//
////        t1.run();
////        t2.run();
//        t1.start();
//        t2.start();

        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        new Thread(() -> {
            try {
                Thread.sleep(new Random().nextInt(2000));
                System.out.println("Thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        System.out.println("Main execution complete.");

    }
}
