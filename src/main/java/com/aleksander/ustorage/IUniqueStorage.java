package com.aleksander.ustorage;

public interface IUniqueStorage<T> extends Iterable<T> {
    void add(T type);
    boolean contains(T type);
    T remove(T type) throws UStorageException;
}
