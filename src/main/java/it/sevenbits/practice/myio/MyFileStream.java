package it.sevenbits.practice.myio;

public interface MyFileStream {
    String readLine() throws MyFileReaderException;
    boolean hasMoreLines() throws MyFileReaderException;
}
