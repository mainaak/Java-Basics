import classOrganiser.ConditionalOperators;
import componentsForMain.SwitchMethod;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        //Object
        SwitchMethod runSwitch = new SwitchMethod();

        //Scanner
        Scanner chooseClass = new Scanner(System.in);
        String chosenOption;

        System.out.println("Which class to run?");
        chosenOption = chooseClass.nextLine();

        runSwitch.runSwitch(Integer.parseInt(chosenOption));
    }
}