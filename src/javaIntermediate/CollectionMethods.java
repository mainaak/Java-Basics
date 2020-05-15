package javaIntermediate;

import java.util.*;

public class CollectionMethods {

    public CollectionMethods() {
        sortAscending();
        sortDescending();
        reverseArray();
        copyList();
        fillList();
        addLists();
        frequencyOfAnItem();
        disjointsInTwoLists();
    }

    private void sortAscending() {
        System.out.println("\nSorting in ascending order:");
        //Creating a string array and adding it into a list
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        //Converting String[] to List<String>
        List<String> stringList = new LinkedList<>(Arrays.asList(stringArray));
        //Sorting using collections
        Collections.sort(stringList);
        //Converting back to String[]
        stringArray = stringList.toArray(new String[stringList.size()]);
        for (String string : stringArray)
            System.out.print(string + " ");
    }

    private void sortDescending() {
        System.out.println("\nSorting in descending order");
        String[] stringArray = {"Nepal", "India", "China", "Pakistan", "Russia", "Sri Lanka", "England"};
        List<String> stringList = Arrays.asList(stringArray);
        Collections.sort(stringList, Collections.reverseOrder());
        ListIterator listIterator = stringList.listIterator();
        while (listIterator.hasNext())
            System.out.print(listIterator.next() + " ");
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

    private void frequencyOfAnItem() {
        System.out.println("Calculating s in Mississippi:");
        Character[] character = {'m', 'i', 's', 's', 'i', 's', 's', 'i', 'p', 'p', 'i'};
        List<Character> characterList = new LinkedList<>(Arrays.asList(character));
        System.out.println(Collections.frequency(characterList, 's'));
    }

    private void disjointsInTwoLists(){
        System.out.println("Calculating if two Strings have common alphabets:");
        Character[] character1 = {'m', 'i', 's', 's', 'i', 's', 's', 'i', 'p', 'p', 'i'};
        Character[] character2 = {'g','u','e','t','t','a'};

        List<Character> characterList1 = Arrays.asList(character1);
        List<Character> characterList2 = Arrays.asList(character2);

        String[] string1 = characterList1.toArray(new String[characterList1.size()]);

        if (Collections.disjoint(characterList1,characterList2)){
            System.out.println(string1.toString() +" & "+characterList2+" have no character in common");
        }
        else{
            System.out.println(characterList1+" & "+characterList2+" have characters in common");
        }
        //make queing system using queue
    }
}
