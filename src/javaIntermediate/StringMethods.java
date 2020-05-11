package javaIntermediate;

import java.util.*;

public class StringMethods {

    public StringMethods(String startingPattern, String endingPattern) {
        ArrayList<String> c = endingWith(beginningWith(takeInputFromUser(), startingPattern), endingPattern);
        for (String d : c) {
            System.out.println(d);
        }
    }

    private ArrayList<String> takeInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        int valueCounter = 0;
        ArrayList<String> inputArray = new ArrayList<>();

        while (valueCounter < 5) {
            System.out.println("Enter value " + ++valueCounter);
            inputArray.add(scanner.nextLine());
        }
        return inputArray;
    }

    public ArrayList<String> beginningWith(ArrayList<String> unfilteredList, String startingPattern) {
        ArrayList<String> finalList = new ArrayList<>();
        for (String validateItem : unfilteredList) {
            if (validateItem.startsWith(startingPattern)) {
                finalList.add(validateItem);
            }
        }
        return finalList;
    }

    private ArrayList<String> endingWith(ArrayList<String> unfilteredList, String endingPattern) {
        ArrayList<String> finalList = new ArrayList<>();
        for (String validateItem : unfilteredList) {
            if (validateItem.endsWith(endingPattern)) {
                finalList.add(validateItem);
            }
        }
        return finalList;
    }
}
