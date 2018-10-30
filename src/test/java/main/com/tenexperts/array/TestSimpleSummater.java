package main.com.tenexperts.array;

import org.junit.Assert;
import org.junit.Test;

public class TestSimpleSummater {

    @Test
    public void simpleSum() throws ArraySummaterException {
        SimpleSummater simpleSummater = new SimpleSummater();
        int[] simpleArray = new int[] {1,2,3,4,5};

        Assert.assertEquals(15 ,simpleSummater.sum(simpleArray));
    }

    @Test
    public void sumAllZero() throws ArraySummaterException {
        SimpleSummater simpleSummater = new SimpleSummater();
        int[] simpleArray = new int[] {0,0,0,0,0};

        Assert.assertEquals(0 ,simpleSummater.sum(simpleArray));
    }

    @Test
    public void sumAllNegative() throws ArraySummaterException {
        SimpleSummater simpleSummater = new SimpleSummater();
        int[] simpleArray = new int[] {-1,-2,-3,-4,-5};

        Assert.assertEquals(-15 ,simpleSummater.sum(simpleArray));
    }

    @Test(expected = ArraySummaterException.class)
    public void emptyArray() throws ArraySummaterException {
        SimpleSummater simpleSummater = new SimpleSummater();
        int[] simpleArray = new int[0];

        simpleSummater.sum(simpleArray);
    }

    @Test(expected = ArraySummaterException.class)
    public void nullArray() throws ArraySummaterException {
        SimpleSummater simpleSummater = new SimpleSummater();
        int[] simpleArray = null;

        simpleSummater.sum(simpleArray);
    }

}
