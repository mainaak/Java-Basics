package javaIntermediate;

import java.util.*;

public class CollectionMethods {

    public CollectionMethods() {
        //Sorting in ascending after converting back to String[]
        for (String item : sortAscending()) {
            System.out.print(item + " ");
        }

        for (String item : sortDescending()) {
            System.out.print(item + " ");
        }

        reverseArray();
        copyList();
        fillList();
        addLists();
    }

    private String[] sortAscending() {
        System.out.println("\nSorting in ascending order:");
        //Creating a string array and adding it into a list
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        //Converting String[] to List<String>
        List<String> stringList = new LinkedList<>(Arrays.asList(stringArray));
        //Sorting using collections
        Collections.sort(stringList);
        //Converting back to String[]
        stringArray = stringList.toArray(new String[stringList.size()]);
        return stringArray;
    }

    private List<String> sortDescending() {
        System.out.println("\nSorting in descending order");
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        List<String> stringList = Arrays.asList(stringArray);
        Collections.sort(stringList, Collections.reverseOrder());
        return stringList;
    }

    private void reverseArray() {
        System.out.println("\nReverse List:");
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        List<String> stringList = new LinkedList<>(Arrays.asList(stringArray));
        stringList.add("USA");
        stringList.remove("Pakistan");
        Collections.reverse(stringList);
        System.out.println(stringList);
    }

    private void copyList() {
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        List<String> stringList = new LinkedList<>(Arrays.asList(stringArray));

        String[] cloneString = new String[stringArray.length];
        List<String> cloneList = new LinkedList<>(Arrays.asList(cloneString));
        Collections.copy(cloneList, stringList);
        System.out.println("\nCloning Lists");
        System.out.println(stringList);
        System.out.println(cloneList);
    }

    private void fillList() {
        List<String> stringList = new LinkedList<>(Arrays.asList("Nepal", "India", "China", "Russia"));
        Collections.fill(stringList, "<empty>");
        System.out.println("Filling List:\n" + stringList);
    }

    private void addLists() {
        String[] stringArray1 = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        List<String> stringList1 = Arrays.asList(stringArray1);

        String[] stringArray2 = {"Kathmandu", "New Delhi", "Beijing", "Islamabad", "Moscow", "Colombia", "London"};
        List<String> stringList2 = new LinkedList<>(Arrays.asList(stringArray2));

        Collections.addAll(stringList2, stringArray1);
        Collections.sort(stringList2);
        System.out.println("Adding List:\n" + stringList2);
    }
}
