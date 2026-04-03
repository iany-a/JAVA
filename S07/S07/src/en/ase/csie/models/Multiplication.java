package en.ase.csie.models;

import en.ase.csie.abstracts.Operation;

public class Multiplication implements Operation {
    @Override
    public int operation(int a, int b) {
        return a*b;
    }
}
