package com.aleksander.ustorage;

public class UStorageException extends Exception {

    public UStorageException() {
    }

    public UStorageException(String message) {
        super(message);
    }

    public UStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UStorageException(Throwable cause) {
        super(cause);
    }
}
