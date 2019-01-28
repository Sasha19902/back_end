package com.aleksander.ustorage;

public class Main {

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

        for (Planet planet : uniqueStorage) {
            System.out.println(planet);
        }

        try {
            uniqueStorage.remove(planet8);
            uniqueStorage.remove(planet7);
            uniqueStorage.remove(planet1);
            uniqueStorage.remove(planet5);
            uniqueStorage.remove(planet5);
        } catch (UStorageException e) {

        }


        for (Planet planet : uniqueStorage) {
            System.out.println(planet);
        }
    }
}
