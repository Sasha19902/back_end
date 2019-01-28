package com.aleksander.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListOperator listOperator = new ListOperator();
        List<Integer> list1 = new ArrayList<>();
        List<Account> list2 = new LinkedList<>();


        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        System.out.println(list1);
        //нумерация с 0
        listOperator.swap(list1, 1, 2);
        System.out.println(list1);

        System.out.println(listOperator.max(list1, 0, 3));

        System.out.println("//////////////////////");

        System.out.println("\n\n");
        list2.add(new Account(100));
        list2.add(new Account(300));
        list2.add(new Account(400));
        list2.add(new Account(200));

        System.out.println(list2);
        listOperator.swap(list2, 2, 3);
        listOperator.swap(list2, 1, 2);
        System.out.println(list2);


        System.out.println(listOperator.max(list2, 0, 3));


    }
}
