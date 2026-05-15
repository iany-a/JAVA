package test2;

public class Calculator {
    public static boolean hasLiftedThreshold(Bodybuilder b){
        return (b.liftedWeight * b.repetitions) > (b.weight*3);
    }
}
