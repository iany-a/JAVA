package en.ase.csie;

import java.util.Random;

public class MyRunnable implements Runnable{

    public static int a;
    public static int b;
    private static Object lock = new Object();

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            add();
        }
    }

    public void add() {
        synchronized(lock){
            a++;
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b++;
            System.out.println("a = " + a + ", b = " + b);
        }
    }
}
