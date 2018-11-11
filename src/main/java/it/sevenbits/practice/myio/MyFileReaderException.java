package it.sevenbits.practice.myio;

import java.io.IOException;

public class MyFileReaderException extends IOException {

    public MyFileReaderException() {
        super();
    }

    public MyFileReaderException(String message) {
        super(message);
    }

    public MyFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFileReaderException(Throwable cause) {
        super(cause);
    }
}
