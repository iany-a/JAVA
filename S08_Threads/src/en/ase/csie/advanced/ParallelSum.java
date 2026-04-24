package en.ase.csie.advanced;

public class ParallelSum extends Thread{
    private long[] array;
    private long startIndex;
    private long endIndex;
    private long sum = 0;

    public long sum() {
        return sum;
    }

    public ParallelSum(long[] array, long startIndex, long endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        super.run();
        for (int i = Math.toIntExact(startIndex); i<endIndex; i++){
            sum += array[i];
        }

    }
}
