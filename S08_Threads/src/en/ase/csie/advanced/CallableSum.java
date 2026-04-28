package en.ase.csie.advanced;

import java.util.concurrent.Callable;

public class CallableSum implements Callable<Long> {
    private long[] array;
    private long startIndex;
    private long endIndex;

    public CallableSum(long[] array, long startIndex, long endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }



    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = Math.toIntExact(startIndex); i<endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
}
