package en.ase.csie.advanced;

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
            arrSum[i] = new ParallelSum(arr1, (long) (i + 1) *NO_ELEM/NO_THREADS, (long) i *NO_ELEM/NO_THREADS);
            arrSum[i].start();
        }
        for(int i=0; i<NO_THREADS; i++){
            arrSum[i].join();
            sum += arrSum[i].sum();
        }

        System.out.println("Sequential: s= " + " " + (System.currentTimeMillis() - time));


    }
}
