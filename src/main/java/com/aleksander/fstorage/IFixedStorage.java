package com.aleksander.fstorage;

public interface IFixedStorage<K, V> extends Iterable<Pair<K, V>> {

    void add(K key,V value);
    V remove(K key) throws FStorageException;
    V get(K key) throws FStorageException;
    boolean contains(V value);
}
