package en.ase.csie.advanced;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int NO_ELEM = 1_000_000;
        int NO_THREADS = 4;

        long[] arr1 = new long[NO_ELEM];
        for (int i=0; i<NO_ELEM; i++){
            arr1[i] = i+1;
        }

        long time = System.currentTimeMillis();
        long sum = 0;
        for (int i=0; i<NO_ELEM; i++){
            sum += arr1[i];
        }
        System.out.println("Sequential: s= " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;

        ParallelSum[] arrSum = new ParallelSum[NO_THREADS];

        for(int i=0; i<NO_THREADS; i++){
            arrSum[i] = new ParallelSum(arr1, (long) i *NO_ELEM/NO_THREADS, (long) (i+1) *NO_ELEM/NO_THREADS);
            arrSum[i].start();
        }
        for(int i=0; i<NO_THREADS; i++){
            arrSum[i].join();
            sum += arrSum[i].sum();
        }

        System.out.println("Parallel thread array: s= " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;

        ExecutorService threadpool = Executors.newFixedThreadPool(NO_THREADS);
        arrSum = new ParallelSum[NO_THREADS];
        for(int i=0; i<NO_THREADS; i++){
            arrSum[i] = new ParallelSum(arr1, (long) i *NO_ELEM/NO_THREADS, (long) (i+1) *NO_ELEM/NO_THREADS);
            threadpool.execute(arrSum[i]);
        }

        //always shutdown first and then awaitTermination!! - in this order
        threadpool.shutdown();
        threadpool.awaitTermination(5, TimeUnit.SECONDS);
        for (int i = 0; i<NO_THREADS; i++){
            sum += arrSum[i].sum();

        }

        System.out.println("Threadpool runnable: s= " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;


        threadpool = Executors.newFixedThreadPool(NO_THREADS);
        CallableSum[] cs = new CallableSum[NO_THREADS];
        List<Future<Long>> fl = new ArrayList<>();
        for(int i=0; i<NO_THREADS; i++){
            cs[i] = new CallableSum(arr1, (long) i *NO_ELEM/NO_THREADS, (long) (i+1) *NO_ELEM/NO_THREADS);
            fl.add(threadpool.submit(cs[i]));

        }


        threadpool.shutdown();
        //threadpool.awaitTermination(5, TimeUnit.SECONDS); - not needed in callable
        for (Future<Long> f : fl){
            try {
                sum += f.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        System.out.println("Callable: s= " + sum + " " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        sum = 0;






    }
}
