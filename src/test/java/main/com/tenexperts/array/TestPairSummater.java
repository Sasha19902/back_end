package main.com.tenexperts.array;

import org.junit.Assert;
import org.junit.Test;

public class TestPairSummater {

    @Test
    public void testSumSimplePair() throws ArraySummaterException {
        PairSummater pairSummater = new PairSummater();
        int[] simpleArray = new int[]{1,2};

        Assert.assertEquals(3, pairSummater.sum(simpleArray));
    }

    @Test
    public void testSumSimpleTwoPair() throws ArraySummaterException {
        PairSummater pairSummater = new PairSummater();
        int[] simpleArray = new int[]{1,2,3,4};

        Assert.assertEquals(7,pairSummater.sum(simpleArray));
    }

    @Test
    public void testSumAllEquals() throws ArraySummaterException {
        PairSummater pairSummater = new PairSummater();
        int[] simpleArray = new int[] {0,0,0,0,0,0,0,0,0,0};

        Assert.assertEquals(0, pairSummater.sum(simpleArray));
    }

    @Test(expected = ArraySummaterException.class)
    public void emptyArray() throws ArraySummaterException {
        PairSummater pairSummater = new PairSummater();
        int[] simpleArray = new int[0];

        pairSummater.sum(simpleArray);
    }

    @Test(expected = ArraySummaterException.class)
    public void oddArray() throws ArraySummaterException {
        PairSummater pairSummater = new PairSummater();
        int[] simpleArray = new int[]{1,2,3};

        pairSummater.sum(simpleArray);
    }

}
