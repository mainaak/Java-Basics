package componentsForMain;

import classOrganiser.ConditionalOperators;
import classOrganiser.Enumerator;
import classOrganiser.StaticVariables;
import classOrganiser.VariableLengthArguments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumSet;

public class CasesForSwitch extends JFrame {

    private JLabel result;
    private JTextField value1;
    private JButton giveValue1;

    public CasesForSwitch(String caseNumber) {
        super("Cases-For-Switch");

        switch (caseNumber) {
            case "1":
                caseOne();
                break;
            case "2":
                caseTwo();
                break;
            case "3":
                caseThree();
                break;
            case "4":
                caseFour();
                break;
        }
    }

    public CasesForSwitch() {

    }

    //Conditional Operator
    protected void caseOne() {
        ConditionalOperators conditionalOperators = new ConditionalOperators();
        conditionalOperators.compareMethod();
    }

    //Variable length arguments
    protected void caseTwo() {
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
    protected void caseThree() {
        for (Enumerator enumeratorObject : Enumerator.values())
            System.out.printf("%s\t%s\t%s\t%s\n", enumeratorObject.getCar(), enumeratorObject,
                    enumeratorObject.getFuelType(), enumeratorObject.getCarType());
        System.out.println("\n\n\n");

        for (Enumerator enumerator : EnumSet.range(Enumerator.GLC, Enumerator.GT2RS))
            System.out.printf("%s\t%s\t%s\t%s\n", enumerator.getCar(), enumerator,
                    enumerator.getFuelType(), enumerator.getCarType());

    }

    //Static variables
    StaticVariables[] staticVariables = new StaticVariables[4];
    String chosenOption;
    protected void caseFour() {
        staticVariables[0] = new StaticVariables("New Delhi", "Delhi");
        staticVariables[1] = new StaticVariables("Kolkata", "West Bengal");
        staticVariables[2] = new StaticVariables("Chennai", "Tamil Nadu");
        staticVariables[3] = new StaticVariables("Mumbai", "Maharashtra");

        setLayout(new FlowLayout());
        result = new JLabel("Enter the index of object you want details for:");
        add(result);
        value1 = new JTextField(1);
        add(value1);
        giveValue1 = new JButton("Calculate");
        add(giveValue1);

        ButtonHandler BO = new ButtonHandler();
        giveValue1.addActionListener(BO);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent){
            chosenOption = value1.getText();
            JOptionPane.showMessageDialog(null,staticVariables[Integer.valueOf(chosenOption)]);
        }
    }
}
