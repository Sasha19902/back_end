package it.sevenbits.practice.myio;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestExample {

    @Test
    public void testEmptyFileReader() throws MyFileReaderException {

        MyFileStream myFileStream = Mockito.mock(FileReader.class);

        Mockito.when(myFileStream.hasMoreLines()).thenReturn(true, false);
        Mockito.when(myFileStream.readLine()).thenReturn("");

        Assert.assertEquals(0, Example.getLongestLineCharsCount(myFileStream));
    }

    @Test
    public void simpleTestWithThreeStrings() throws MyFileReaderException {

        MyFileStream myFileStream = Mockito.mock(FileReader.class);

        Mockito.when(myFileStream.readLine()).thenReturn("aaaa", "zzz", "ccccc");
        Mockito.when(myFileStream.hasMoreLines()).thenReturn(true, true, true, false);

        Assert.assertEquals(5, Example.getLongestLineCharsCount(myFileStream));
    }


}
