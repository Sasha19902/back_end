package main.com.tenexperts.array;

public class Main {

    public static void main(String[] args) throws ArraySummaterException {
        IArraySummater arraySummater = new SimpleSummater();

        final int[] array = new int[]{1, 2, 3, 4, 5};

        int sum = arraySummater.sum(array);
        System.out.println("Array sum is - " + sum);
    }
}
