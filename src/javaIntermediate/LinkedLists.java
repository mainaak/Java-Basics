package javaIntermediate;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedLists {
    String[] stringArray1 = {"apples", "oranges", "kiwi", "banana", "pear", "peach"};
    String[] stringArray2 = {"grapes", "mango", "kiwi", "orange", "lemon"};

    List<String> linkedList1 = new LinkedList<>();
    List<String> linkedList2 = new LinkedList<>();

    private void addArrayToList(String[] array, List<String> linkedList) {
        for (String item : array) {
            linkedList.add(item);
        }
    }

    private void printMe(List<String> linkedList) {
        System.out.println("\nprintMe()");
        Iterator<String> stringIterator = linkedList.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    private void removeStuff(List<String> linkedList, int startIndex, int endIndex) {
        linkedList.subList(startIndex, endIndex).clear();
    }

    private void reverseMe(List<String> linkedList) {
        System.out.println("\nreverseMe()");
        ListIterator<String> reverseIterator = linkedList.listIterator(linkedList.size());
        while (reverseIterator.hasPrevious())
            System.out.println(reverseIterator.previous());
    }

    private void reverseMe2(Integer sizeOfList, List<String> linkedList) {
        if (sizeOfList == 0) {
            System.out.println("Reached the end of the list");
        } else {
            System.out.println(linkedList.get(sizeOfList - 1));
            reverseMe2(sizeOfList - 1, linkedList);
        }
    }


    public LinkedLists() {
        addArrayToList(stringArray1, linkedList1);
        addArrayToList(stringArray2, linkedList2);

        printMe(linkedList1);
        removeStuff(linkedList1, 1, 3);
        printMe(linkedList1);
        reverseMe(linkedList1);
        System.out.println("reverseMe2()");
        reverseMe2(linkedList1.size(),linkedList1);

    }
}
