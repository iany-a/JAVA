package en.ase.csie;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

//        t1.run();
//        t2.run();
        t1.start();
        t2.start();
    }
}
