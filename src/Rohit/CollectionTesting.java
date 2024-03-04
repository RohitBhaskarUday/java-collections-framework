package Rohit;


import java.util.*;

public class CollectionTesting {

    public static void main(String[] args) {
//        ourGenericList<Integer> list = new ourGenericList<>();
//        list.add(101);
//        list.add(202);
//      //  for(int i: list) // we cannot iterate through a list using forloop.
//
////        Iterator<Integer> iterator = list.iterator();
////        while (iterator.hasNext())
////            System.out.println(iterator.next());
//
//        for (int i: list)
//            System.out.println(i);
//        }

        System.out.println(":::::---ArrayList---::::::");


        // ArrayList 1
        List<Integer> array_list = new ArrayList<>();
        array_list.add(11);
        array_list.add(12);
        array_list.add(13);
        array_list.add(12);

        //set method set(index,value)
        //System.out.println("Element replaced "+array_list.set(1,100));

        //ArrayList 2
        List<Integer> array_list_2 = new ArrayList<>();
        array_list_2.add(14);
        array_list_2.add(15);
        array_list_2.add(16);

        //addAll method.
        array_list_2.addAll(array_list);
        //indexOf method.
        System.out.println(array_list.indexOf(12));  // the compiler automatically does the convert the 12 into the new Integer to pass it as a reference.
        //lastIndexOf method.
        System.out.println(array_list.lastIndexOf(12));


        //ArrayList 3 //subList method subList(start_index, last_index)
        //<14,15,16,11,12> //  the last index (12) will be exclusive. It will not be added to the list.
        List<Integer> array_list_3 = array_list_2.subList(0,4);
        //use set method now and wait for the magic.
        array_list_3.set(1,30); // this changes will be reflected in the main list as well. which is the array list 2.
        System.out.println("list 3 "+ array_list_3);
        System.out.println("list 2 "+ array_list_2);// position in the array list_2 is also changes. It is because of the shallow copy.
        // Sublist method does not do deep copy. It does is shallow copy.

        System.out.println("::::::____ Method to return array to a function____::::::");

        Integer [] arr = array_list_2.toArray(new Integer[0]);
        for(int i : arr)
            System.out.println(i);



        System.out.println("::::::---LinkedList---::::::");

        //LinkedList
        List<Integer> linked_list = new LinkedList<>();

        linked_list.add(1);
        linked_list.add(2);
        linked_list.add(3);

        // [1,2,3]
        //for iterating over a linked list. we can use iterator interface.
        ListIterator<Integer> iterator = linked_list.listIterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());  //output 1,2,2

        //explanation
        //next() ---- next = return items[index ++];  //First return the item and then increment the index position.
        //previous() ---- prev = return items[-- index]; //First decrement the index position/cursor and then return the item.

        System.out.println("::::----QUEUE-----::::");

        Queue<Integer> q = new LinkedList<>(); //we use LinkedList for FIFO ordering queue
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(5);

        //[1,2,3,5] // This is our FIFO Queue.
        System.out.println(q.peek()); // we will check the element in the queue
        System.out.println(q.poll()); // We will remove the element
        System.out.println(q.peek()); // we will check the first element

        System.out.println(q.isEmpty()); //Returns boolean value to check if it exists or not.

        System.out.println("::::::----STACK----::::::");

        Stack<Integer> s = new Stack<>(); //stack has its own class.
        s.push(1);
        s.push(2);
        s.push(3);


        while(!s.isEmpty()){
            System.out.println(s.peek()); // you can use the methods of different class to view
            s.pop();
        }


        System.out.println("-----:::Deque for double ended queue using ArrayDeque:::-----");
        //For double Ended Queue.
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(1);
        dq.offerFirst(2);
        dq.offerFirst(3);
        System.out.println(dq);

        dq.pollFirst();
        System.out.println(dq.peekFirst());
        System.out.println(dq);

        System.out.println("::::----PRIORITY QUEUE-----::::: (with comparator interface example)");
//What if we want top 2 elements instead of bottom 2 elements????
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(100);
        pq.offer(0);

        //top 2 elements inside this priority queue.
        List<Integer> top_2 = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty())
        {
            if(index == 2) break;
            top_2.add(pq.poll());
            index++;
        }

        System.out.println(top_2);
        System.out.println(pq);





        System.out.println("::::----PRIORITY QUEUE-----::::: (with comparable interface example)");

        //example!   //Get me the top 3 students scores according to their maths marks

        List<StudentMarks> list_marks = new ArrayList<>();
        list_marks.add(new StudentMarks(10,20));
        list_marks.add(new StudentMarks(49,40));
        list_marks.add(new StudentMarks(30,50));
        list_marks.add(new StudentMarks(100,100));
        list_marks.add(new StudentMarks(80,90));

//instead of using so much code to iterate using for loop we can just use the instance of the list
        //PriorityQueue<StudentMarks> marks = new PriorityQueue<>(list_marks);

//new priority queue. (with anonymous class I guess this is.
        PriorityQueue<StudentMarks> marks = new PriorityQueue<>((s1,s2) ->
        {
            System.out.println("Comparator's compareTo() is called");
            return s2.getScience() - s1.getMaths();
        });

        for (StudentMarks sm : list_marks) {
            marks.add(sm);
        }

        List<StudentMarks> top_3 = new ArrayList<>();
        index=0;
        while(!marks.isEmpty())
        {
            if(index == 3) break;;
            top_3.add(marks.poll());  // cannot cast to class because it is in comparable class
            index++;
        }
        System.out.println(top_3);

// The above method does not work. because it can be only achieved via comparable class.
// so, the priority queue will check the class and then checks if it implements comparable interface and this has some compareTo methods in it.

//Now, the comparator will come into picture. since we cannot change the defaultness of the Integer Class since it takes everything in ascending order


        System.out.println("::::---Sets... Lets implement the HashSet---::::");

        Set<Integer> set = new HashSet<>(array_list);
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(0);

        set.addAll(array_list);
        System.out.println(set);

        set.retainAll(array_list); // the Set is changed as it retains all elements of sets in array_list
        System.out.println("The retained set is  "+set);
        System.out.println(set.contains(1));
        System.out.println(set.contains(1000));

        //point - when you do not need any ordering use a hashset.
        System.out.println("when you do not need any ordering use a hashset ");
        for (int x: set) System.out.println(x);

        System.out.println("::--LinkedHashSet--//insertion order is maintained::");

        Set<StudentMarks> set3 = new HashSet<>(list_marks);
        for (StudentMarks x: set3) System.out.println(x+",");


        System.out.println(set3.contains(new StudentMarks(49,40))); // this gives us false

        //why this is happening. whenever we insert the element to a hashset, hashcode is generated for it. it would be inside of the bucket
        // in the bucket it goes to the linkedlist position of its particular area.
        //Now, to generate the hashcode
        // after implementing the equals() and hashCode() method in the custom class you can run the above HashSet<>

        System.out.println(":::-----TreeSet------(with NavigableSet):::");

        Set<StudentMarks> treeset = new TreeSet<>((s1,s2) -> s2.getScience() - s1.getMaths()); //very similar to priority queue
        treeset.add(new StudentMarks(100,90));
        treeset.add(new StudentMarks(99,90));
        treeset.add(new StudentMarks(80,80));
        treeset.add(new StudentMarks(75,75));
        for (StudentMarks x: treeset) System.out.print(x+",");

        System.out.println("--------");

        NavigableSet<Integer> set5 = new TreeSet<>();
        set5.add(1);
        set5.add(5);
        set5.add(8);
        set5.add(0);
        set5.add(3);
        for (int x : set5) System.out.print(x +",");
        System.out.println();
        System.out.println("The methods in a part of NavigableSet and not a part of set interface");
        System.out.println(set5.floor(4)+" floor(4) just prints the <= less than or equal to value of the passed value in the set");
        System.out.println(set5.higher(7)+" higher(7) prints the next highest value to the number in the set");
        System.out.println(set5.lower(1)+" lower(0) prints the strictly next lowest value to the number in the set");
        System.out.println(set5.ceiling(2)+" ceiling(2) prints the >= greater than or equal to value of the passed value in the set");

        System.out.println(":::-----Lets learn MAP----:::::");

        Map<String, Integer> map = new HashMap<>();
        map.put("rohit", 1);
        map.put("sandeep",2);
        map.put("joey",3);
        //map.remove("rohit");

        //System.out.println(map.get("dsds").getMaths());
        System.out.println(map.getOrDefault("dsbdsjh",0));
        System.out.println(map.getOrDefault("sandeep",2));

        System.out.println(map.containsKey("rohit"));

        //Traversing Graphs...
        // Creating an adjacency list for graphs using HashMaps
        // adjacency list means mapping of a node to the list of nodes it can be traversed from that particular node.

        System.out.println(" Traversing in Graphs and..");
        System.out.println("Creating adjacent list for graphs using Hashmaps");

        Map<Integer, List<Integer>> adj = new HashMap<>();

        if(adj.get(1) == null)
            adj.put(1,new ArrayList<>());
        adj.get(1).add(2);

        adj.computeIfAbsent(1,f -> new ArrayList<>()).add(2);


        System.out.println("MAP TRAVERSALS");

       //way 1 traversal of maps
       Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
       for(Map.Entry<String,Integer> entry : entrySet)
           System.out.println(entry.getKey() + "," + entry.getValue());

       //Way 2 traversal of maps
       Set<String> keySets = map.keySet();
       for(String key: keySets)
           System.out.println(key +"-"+map.get(key));

        System.out.println(":::------TreeMap------:::");

        NavigableMap<Integer, String> Tmap = new TreeMap<>((a,b) -> b-a);
        Tmap.put(1,"Rohit");
        Tmap.put(2,"Panjan");
        Tmap.put(3,"Vishnu");
        Tmap.remove(2);

        //System.out.println(Tmap);

        Set<Map.Entry<Integer, String>> entryset_2 = Tmap.entrySet();
        for (Map.Entry<Integer, String> entry: entryset_2)
            System.out.println(entry.getKey() + "," + entry.getValue());

        System.out.println(Tmap.pollFirstEntry() + " pollFirstEntry() method");
        System.out.println(Tmap.ceilingKey(3) + " ceilingKey(3) method");
        System.out.println(Tmap.ceilingEntry(3) + " ceilingEntry() method");

        //create own hashmap, arraylist, generics. also.

        //DSA Methods for array sorting

        //Integer arr1[] = new Integer[][] {1,5,54,0,6,2,8,3};
        //Arrays.sort(arr1);

        //Collections.sort(arr1,Collections.reverseOrder());

        //List<Integer> lst = Arrays.asList(arr1); //Only works on Wrapper classes.

        //Collections IN Binary search

        //Collections.binarySearch ---- but always use upper bound and lower bound.






































































    }
}
