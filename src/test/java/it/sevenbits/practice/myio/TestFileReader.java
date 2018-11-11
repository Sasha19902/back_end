package it.sevenbits.practice.myio;

import org.junit.Assert;
import org.junit.Test;

public class TestFileReader {

    @Test
    public void simpleTestReadLine() throws MyFileReaderException {

        final String checkToContain = "7bits-checkstyle.xml";
        FileReader fileReader = new FileReader("Homework3.txt");

        fileReader.readLine();
        fileReader.readLine();
        String test = fileReader.readLine();

        Assert.assertTrue(test.contains(checkToContain));
    }

    @Test(expected = MyFileReaderException.class)
    public void testThrowException() throws MyFileReaderException {
        FileReader fileReader = new FileReader("");
    }


}
