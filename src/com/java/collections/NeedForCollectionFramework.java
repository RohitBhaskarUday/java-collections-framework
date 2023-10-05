package com.java.collections;


import java.util.Objects;

class Book{

}

class Student{

}

public class NeedForCollectionFramework {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        // For creating 10 or 10,000 integer variables we need to have 10 variables
        //which is a worst programming technique by creating 10,000 variables.
        // SO we create array to hold homogeneous data types.

        int[] arr = new int[10000]; // so we can store 10,000 variables with a single place.

        //but array is fixed size. we cannot increase the size later as per our requirement.

        // Limitations of an array
        //1. Arrays are fixed in size.
        //2. only hold homogeneous data elements.

        Student[] students = new Student[10];
        students[0] = new Student();
        students[1] = new Student(); // cannot change array like Book();
        //students[1] = new Book();

        Object[] objects = new Object[10];
        objects[0] = new Student();
        objects[1] = new Student(); //Object is the superclass for all classes
        objects[1] = new Book();    // so we can override it to create different objects,

        //3. Array concept are not created using any Data Structure to write any logic for
        //creating an algorithm. There are no ready-made logic available for arrays.
        //Ready-made support is not available in arrays.

        //To Overcome these limitations of an "Array" we have come through collection framework.




    }
}

