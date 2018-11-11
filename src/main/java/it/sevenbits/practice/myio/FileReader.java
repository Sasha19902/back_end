package it.sevenbits.practice.myio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class FileReader implements AutoCloseable, MyFileStream {

    private BufferedReader bufferedReader;
    private String fileName;
    private int readedLines;

    public FileReader(String path) throws MyFileReaderException {
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(path));
        } catch (FileNotFoundException e) {
            throw new MyFileReaderException(e.getMessage());
        }

        String[] parseName = path.split("/");
        fileName = parseName[parseName.length - 1];
    }

    public Stream<String> lines() {

        return bufferedReader.lines();
    }

    @Override
    public String readLine() throws MyFileReaderException {
        StringBuilder result = new StringBuilder();
        String line = null;

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            throw new MyFileReaderException(e.getMessage());
        }

        if(line == null)
            throw new MyFileReaderException("No found elements");

        return result.append(fileName).append(" line ").append(++readedLines).append(" : ").append(line).toString();
    }

    @Override
    public boolean hasMoreLines() throws MyFileReaderException {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            throw new MyFileReaderException(e.getMessage());
        }
    }

    @Override
    public void close() throws MyFileReaderException {
        try {
            bufferedReader.close();
        } catch (Exception e) {
            throw new MyFileReaderException(e.getMessage());
        }
    }
}
