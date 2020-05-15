package javaIntermediate;

import java.util.*;

public class GenericMethods {

    private String[] stringValues = {"Mainaak", "Amit", "Ankit", "Abhishek"};
    private Character[] characterValues = {'M', 'a', 'i', 'n', 'a', 'a', 'k'};
    private Integer[] integerValues = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public GenericMethods() {
        printMethods();
        System.out.println(returnList(stringValues));
    }

    private void printMethods(){
        printThis(stringValues);
        printThis(characterValues);
        printThis(integerValues);
    }

    private <T> void printThis(T[] variable) {

        for (T item : variable) {
            System.out.printf("%s ", item);
        }
        List<T> listOfVariables = new LinkedList<>(Arrays.asList(variable));
        Set<T> setOfVariables = new HashSet<>(listOfVariables);
        listOfVariables = new LinkedList<>(setOfVariables);
        Collections.sort(listOfVariables, Collections.reverseOrder());
        System.out.println(listOfVariables);
    }

    private <T> List<T> returnList(T[] variables){
        List<T> linkedList = new LinkedList(Arrays.asList(variables));
        return linkedList;
    }
}