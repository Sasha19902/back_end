package main.it.sevenbits;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Segment[] segments = {new Segment(new Point2D(1, 2), new Point2D(5, 2)),
                              new Segment(new Point2D(3,1),  new Point2D(7, 7)),
                              new Segment(new Point2D(2,2), new Point2D(5,5 ))};

        Arrays.stream(segments).forEach(seg -> {
            System.out.println("Длина отрезка - " + seg.length());
        });

        double maxLength = Objects.requireNonNull(Arrays.stream(segments).max(Comparator.comparingDouble(Segment::length))
                                                         .orElse(null))
                                                         .length();

        System.out.println("Самый длинный отрезок длинной - " + maxLength);

    }
}
