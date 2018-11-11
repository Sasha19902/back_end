package it.sevenbits.practice.myio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestExample {

    @Test
    public void testEmptyFileReader() throws MyFileReaderException {

        MyStringReader myStringReader = Mockito.mock(FileReader.class);

        Mockito.when(myStringReader.hasMoreLines()).thenReturn(true, false);
        Mockito.when(myStringReader.readLine()).thenReturn("");

        Assert.assertEquals(0, Example.getLongestLineCharsCount(myStringReader));
    }

    @Test
    public void simpleTestWithThreeStrings() throws MyFileReaderException {

        MyStringReader myStringReader = Mockito.mock(FileReader.class);

        Mockito.when(myStringReader.readLine()).thenReturn("aaaa", "zzz", "ccccc");
        Mockito.when(myStringReader.hasMoreLines()).thenReturn(true, true, true, false);

        Assert.assertEquals(5, Example.getLongestLineCharsCount(myStringReader));
    }


}
