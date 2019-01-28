package com.aleksander.generics;

import java.util.List;


public class ListOperator {

    public <T extends Comparable<T>> T max(List<T> list, int startIndex, int endIndex) {
        T maxElement = list.get(startIndex);

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if(maxElement.compareTo(list.get(i)) < 0) {
                maxElement = list.get(i);
            }
        }
        return maxElement;
    }

    public <T> void swap(List<T> list, int first, int second) {
        T element = list.get(first);
        list.set(first, list.get(second));
        list.set(second, element);
    }


}
