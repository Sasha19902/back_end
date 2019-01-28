package com.aleksander.ustorage;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Iterator;

public class LinkedStorage<T> implements IUniqueStorage<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedStorage.class);

    private Node<T> start;

    public LinkedStorage() {
        start = null;
    }

    public void add(T type) {
        Node<T> find = start;
        boolean flagCollision = false;

        if (find == null) {
            LOGGER.info("ELEMENT: " + type + " was added");
            find = new Node<>(null, null, type);
            start = find;
        } else {
            //find end && check contains
            while (find.next != null) {

                if (find.value.equals(type)) {
                    flagCollision = true;
                }
                find = find.next;

            }
            if (flagCollision) {
                LOGGER.info("ELEMENT: " + type + " is already in storage");
            } else {
                find.next = new Node<T>(null, find, type);
                LOGGER.info("ELEMENT: " + type + " was added");
            }
        }
    }

    public boolean contains(T type) {
        Node<T> findValue = start;

        for (; findValue != null; findValue = findValue.next) {
            if (findValue.value.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public T remove(T type) throws UStorageException {

        Node<T> findValue = start;
        boolean finded = false;

        for (; findValue != null && !finded; findValue = findValue.next) {
            if (findValue.value.equals(type)) {
                finded = true;
                break;
            }
        }

        if (finded) {
            Node<T> save = findValue;

            if (start.value.equals(findValue.value)) {
                start = start.next;
            } else {
                if (findValue.next == null) {
                    findValue.prev.next = null;
                } else {
                    findValue.prev.next = findValue.next;
                    findValue.next.prev = findValue.prev;
                }
            }
            LOGGER.info("ELEMENT: " + type + " was removed");
            return save.value;
        } else {
            LOGGER.error("Not found element");
            throw new UStorageException("Not found element");
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = start;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    private static class Node<T> {

        Node<T> next;
        Node<T> prev;
        T value;

        Node(Node<T> next, Node<T> prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
