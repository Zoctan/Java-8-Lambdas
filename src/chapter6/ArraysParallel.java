package chapter6;

import java.util.Arrays;

public class ArraysParallel {
    public static void main(String[] args) {
        double[] init1 = imperativeInitialize(10);
        double[] init2 = imperativeInitializeParallelSetAll(10);
        assert Arrays.equals(init1, init2);
    }

    private static double[] imperativeInitialize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }

    private static double[] imperativeInitializeParallelSetAll(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }
}
