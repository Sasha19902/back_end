package com.aleksander.fstorage;

import com.aleksander.ustorage.LinkedStorage;
import com.aleksander.ustorage.UStorageException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Iterator;

public class MapStorage<K, V> implements IFixedStorage<K, V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapStorage.class);
    private LinkedStorage<Pair<K, V>>[] simpleTable;
    private int capacity;
    private int size;

    public MapStorage(int capacity) {
        this.capacity = capacity;
        simpleTable = new LinkedStorage[capacity];

        for (int i = 0; i < simpleTable.length; i++) {
            simpleTable[i] = new LinkedStorage<>();
        }
    }

    @Override
    public void add(K key, V value) {

        int hash = key.hashCode();

        //find equals key
        Pair<K, V> mark = null;
        LinkedStorage<Pair<K, V>> storage = simpleTable[Math.abs(hash) % simpleTable.length];
        for (Pair<K, V> await : storage) {
            if (await.getKey().equals(key)) {
                mark = await;
            }
        }

        if (mark != null) {
            mark.setValue(value);
            LOGGER.info("Key already to use. Change value...");
        } else {
            if (capacity == size) {
                LOGGER.info("The allocated buffer is full");
            } else {
                simpleTable[Math.abs(hash) % simpleTable.length].add(new Pair<>(key, value));
                size++;
                LOGGER.info("Key and value added...");
            }
        }
    }

    @Override
    public V remove(K key) throws FStorageException {
        int hash = key.hashCode();
        Pair<K, V> await = null;
        LinkedStorage<Pair<K, V>> storage = simpleTable[Math.abs(hash) % simpleTable.length];

        for (Pair<K, V> pair : storage) {
            if (pair.getKey().equals(key)) {
                await = pair;
                break;
            }
        }

        if (await == null) {
            LOGGER.error("Unknown type key: " + key);
            throw new FStorageException("Unknown type key: " + key);
        }

        try {
            storage.remove(await);
            LOGGER.info("remove " + await + "...");
        } catch (UStorageException e) {
            throw new FStorageException(e.getMessage());
        }
        size--;
        return await.getValue();
    }

    @Override
    public V get(K key) throws FStorageException {
        int hash = key.hashCode();
        Pair<K, V> await = null;
        LinkedStorage<Pair<K, V>> storage = simpleTable[Math.abs(hash) % simpleTable.length];

        for (Pair<K, V> pair : storage) {
            if (pair.getKey().equals(key)) {
                await = pair;
                break;
            }
        }

        if (await == null) {
            throw new FStorageException("Unknown type key: " + key);
        }

        return await.getValue();
    }

    @Override
    public boolean contains(V value) {

        for (LinkedStorage<Pair<K, V>> storage : simpleTable) {
            for (Pair<K, V> pair : storage) {
                if (pair.getValue().equals(value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new Iterator<>() {

            private int position;
            private Iterator<Pair<K, V>> lsIterator;

            @Override
            public boolean hasNext() {
                //initilizing...
                if (lsIterator == null) {
                    boolean finded = false;
                    while (position < simpleTable.length && !finded) {
                        finded = (lsIterator = simpleTable[position].iterator()).hasNext();
                        position++;
                    }
                    //empty table
                    if (!finded) {
                        return false;
                    }
                }

                while (!lsIterator.hasNext() && position < simpleTable.length) {
                    lsIterator = simpleTable[position].iterator();
                    position++;
                }

                return lsIterator.hasNext();
            }

            @Override
            public Pair<K, V> next() {
                return lsIterator.next();
            }
        };
    }
}
