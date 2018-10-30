package main.com.tenexperts.array;

public class PairSummater implements IArraySummater {

    @Override
    public int sum(final int[] summing) throws ArraySummaterException {
        if (summing == null || summing.length % 2 != 0 || summing.length == 0) {
            throw new ArraySummaterException("Bad");
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < summing.length; i += 2) {
            if (summing[i - 1] + summing[i] > result) {
                result = summing[i - 1] + summing[i];
            }
        }

        return result;
    }
}
