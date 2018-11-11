package it.sevenbits.practice.myio;

public interface MyStringReader {
    String readLine() throws MyFileReaderException;
    boolean hasMoreLines() throws MyFileReaderException;
}
