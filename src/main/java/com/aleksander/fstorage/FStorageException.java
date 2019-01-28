package com.aleksander.fstorage;

public class FStorageException extends Exception {

    public FStorageException() {
    }

    public FStorageException(String message) {
        super(message);
    }

    public FStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FStorageException(Throwable cause) {
        super(cause);
    }
}
