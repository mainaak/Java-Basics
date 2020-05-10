import componentsForMain.SwitchMethod;

import javax.swing.*;

public class Main {

    public static void main(String args[]) {
        //Object
        SwitchMethod runSwitch = new SwitchMethod();

        String chosenOption = JOptionPane.showInputDialog("Which class to run?");

        runSwitch.runSwitch(Integer.parseInt(chosenOption));
    }
}