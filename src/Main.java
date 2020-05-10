import classOrganiser.ConditionalOperators;
import classOrganiser.Enumerator;
import classOrganiser.StaticVariables;
import classOrganiser.VariableLengthArguments;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        //Scanner
        Scanner chooseClass = new Scanner(System.in);
        String chosenOption;

        System.out.println("Which class to run?");
        chosenOption = chooseClass.nextLine();

        runSwitch(Integer.parseInt(chosenOption));
    }

    private static void runSwitch(Integer caseNumber) {
        switch (caseNumber) {
            //Conditional Operator
            case 1:
                ConditionalOperators conditionalOperators = new ConditionalOperators();
                conditionalOperators.compareMethod();
                break;
            case 2:
                caseTwo();
                break;
            //Enum
            case 3:
                caseThree();
                break;
            case 4:
                caseFour();
                break;
            default:
                System.out.println("INCORRECT VALUE");
                break;
        }
    }

    //Variable length arguments
    private static void caseTwo() {
        //Initializing object and calling constructor which takes 0 args
        VariableLengthArguments variableLengthArguments = new VariableLengthArguments();
        //Running get method which takes 1 arg
        System.out.println("\nFetching value from the index: " + variableLengthArguments.getValues(3));
        //Cloning into integers using get method which takes 0 arg
        Integer[] integers = variableLengthArguments.getValues();
        System.out.println("\nThis is iteration of list");
        //Advanced for loop
        for (int x : integers) {
            System.out.println(x);
        }
    }

    //Enum
    public static void caseThree() {
        for (Enumerator enumeratorObject : Enumerator.values())
            System.out.printf("%s\t%s\t%s\t%s\n", enumeratorObject.getCar(), enumeratorObject,
                    enumeratorObject.getFuelType(), enumeratorObject.getCarType());

        for (Enumerator enumerator : EnumSet.range(Enumerator.GLC, Enumerator.GT2RS))
            System.out.printf("%s\t%s\t%s\t%s\n", enumerator.getCar(), enumerator,
                    enumerator.getFuelType(), enumerator.getCarType());

    }

    //Static variables
    public static void caseFour() {
        Scanner chooseClass = new Scanner(System.in);
        String chosenOption;
        StaticVariables[] staticVariables;
        staticVariables = new StaticVariables[4];

        staticVariables[0] = new StaticVariables("New Delhi", "Delhi");
        staticVariables[1] = new StaticVariables("Kolkata", "West Bengal");
        staticVariables[2] = new StaticVariables("Chennai", "Tamil Nadu");
        staticVariables[3] = new StaticVariables("Mumbai", "Maharashtra");

        System.out.println("Enter the index of object you want details for:");
        chosenOption = chooseClass.nextLine();
        System.out.println(staticVariables[Integer.parseInt(chosenOption)]);
    }
}