package main.com.tenexperts.array;

import java.util.Arrays;

public class SimpleSummater implements IArraySummater {

    @Override
    public int sum(final int[] summing) throws ArraySummaterException {
        if (summing == null || summing.length == 0) {
            throw new ArraySummaterException("Array is empty");
        }

        return Arrays.stream(summing)
                .sum();
    }
}
