package it.sevenbits.practice.iopractice;

public class MyFileServiceException extends Exception {

    public MyFileServiceException() {
        super();
    }

    public MyFileServiceException(String message) {
        super(message);
    }

    public MyFileServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyFileServiceException(Throwable cause) {
        super(cause);
    }
}
