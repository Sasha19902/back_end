package com.aleksander.fstorage;

import com.aleksander.ustorage.Planet;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        IFixedStorage<String, Planet> fixedStorage = new MapStorage<>(4);
        fixedStorage.add("Mercury", new Planet("Mercury"));
        fixedStorage.add("Venus", new Planet("Venus"));
        fixedStorage.add("Earth", new Planet("Earth"));
        fixedStorage.add("Uranus", new Planet("Uranus"));
        fixedStorage.add("Venus", new Planet("Pluto"));
        fixedStorage.add("Jupiter", new Planet("Jupiter"));

        try {
            fixedStorage.remove("Venus");
        } catch (FStorageException e) {
            e.printStackTrace();
        }

        fixedStorage.add("Jupiter", new Planet("Jupiter"));

        for (Pair<String, Planet> pair: fixedStorage ) {
            System.out.println("KEY: " + pair.getKey() + "  " + pair.getValue());
        }

        try {
            fixedStorage.remove("Mercury");
            fixedStorage.remove("Earth");
            fixedStorage.remove("Uranus");
            fixedStorage.remove("Venus");
        } catch (FStorageException e) {

        }

        for (Pair<String, Planet> pair: fixedStorage ) {
            System.out.println("KEY: " + pair.getKey() + "  " + pair.getValue());
        }
    }
}
