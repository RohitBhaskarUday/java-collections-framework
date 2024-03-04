package com.java.collections.interfaces;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {

    public static void main(String[] args) {

        Collection<String> collection_1 = new ArrayList<>();
        collection_1.add("Elephant");
        collection_1.add("Mango");
        collection_1.add("Cheethah");
        System.out.println(collection_1);

        collection_1.remove("Mango");
        System.out.println(collection_1);


        System.out.println(collection_1.contains("Apple"));

        collection_1.forEach((element) -> {
            System.out.println(element);
        });





    }
}
