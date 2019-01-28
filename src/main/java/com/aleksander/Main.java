package com.aleksander;

import com.aleksander.fstorage.IFixedStorage;
import com.aleksander.fstorage.MapStorage;
import com.aleksander.fstorage.Pair;
import com.aleksander.ustorage.IUniqueStorage;
import com.aleksander.ustorage.LinkedStorage;
import com.aleksander.ustorage.Planet;
import com.aleksander.ustorage.UStorageException;

public class Main {

    public static <T> boolean containsAll(IUniqueStorage<T> uObjects, IFixedStorage<?,T> fObjects) {
        for (Pair<?, T> pair : fObjects) {
            if(!uObjects.contains(pair.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        IUniqueStorage<Planet> uniqueStorage = new LinkedStorage<>();

        Planet planet1 = new Planet("Mercury");
        Planet planet2 = new Planet("Venus");
        Planet planet3 = new Planet("Earth");
        Planet planet4 = new Planet("Mars");
        Planet planet5 = new Planet("Jupiter");
        Planet planet6 = new Planet("Saturn");
        Planet planet7 = new Planet("Uranus");
        Planet planet8 = new Planet("Neptune");

        uniqueStorage.add(planet1);
        uniqueStorage.add(planet2);
        uniqueStorage.add(planet3);
        uniqueStorage.add(planet4);
        uniqueStorage.add(planet5);
        uniqueStorage.add(planet6);
        uniqueStorage.add(planet7);
        uniqueStorage.add(planet8);

        IFixedStorage<String, Planet> fixedStorage = new MapStorage<>(4);
        fixedStorage.add(planet1.getId(), planet1);
        fixedStorage.add(planet4.getId(), planet4);
        fixedStorage.add(planet6.getId(), planet6);
        fixedStorage.add(planet7.getId(), planet7);

        System.out.println(containsAll(uniqueStorage, fixedStorage));

        try {
            uniqueStorage.remove(planet1);
        } catch (UStorageException e) {
            e.printStackTrace();
        }

        System.out.println(containsAll(uniqueStorage, fixedStorage));
    }
}
