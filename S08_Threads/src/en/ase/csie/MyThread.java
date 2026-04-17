package en.ase.csie;

public class MyThread extends Thread{

    //run will be the method where we define what happens on this new thread
    //do not make x and y as static as this will mangle the multi threading
    int x,y = 0;
    @Override
    public void run() {
        super.run();
        for(int i=0; i<5; i++){
        x++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        y++;
        System.out.println("X="+x);
        System.out.println("Y="+y);
        }
    }
}
