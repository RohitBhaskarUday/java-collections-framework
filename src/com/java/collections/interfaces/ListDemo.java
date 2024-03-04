package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        //List allows you to add duplicate elements.
        list.add("Element");
        list.add("Element_");
        list.add("Element");
        System.out.println(list);

        //list allows you to add null elements.
        list.add(null);
        list.add(null);
        System.out.println(list);

        //Insertion order
        list.add("element1");
        list.add("element2");
        System.out.println(list);

        //Access elements from the list
        System.out.println(list.get(1));
        System.out.println(list.get(5));

    }
}
