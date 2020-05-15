package javaIntermediate;

import java.util.*;

public class HashSets {

    //Unlike lists does not allow duplicate items
    public HashSets(){
        String[] stringArray = {"Apples","Oranges","Watermelon","Strawberry","Kiwi"};
        List<String> stringList = new LinkedList<>(Arrays.asList(stringArray));
        System.out.println(stringList);
        stringList.add("Grapefruit");
        System.out.println(stringList);
        Set<String> stringSet = new HashSet<>(stringList);
        System.out.println(stringSet);
        stringSet.add("Lemon");
        stringSet.add("Grapefruit");
        System.out.println(stringSet);
        stringList.clear();
        stringList = new LinkedList<>(stringSet);
        Collections.sort(stringList);
        System.out.println(stringList);
    }
}
