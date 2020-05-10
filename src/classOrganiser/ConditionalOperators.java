package classOrganiser;

import javax.swing.*;

public class ConditionalOperators extends Variables {

    public ConditionalOperators() {
        value[0] = 0;
        value[1] = 0;
    }

    public void compareMethod() {
        System.out.println("Enter value1: ");
        value[0] = input.nextInt();
        System.out.println("Enter value2: ");
        value[1] = input.nextInt();

        JOptionPane.showMessageDialog(null, value[0] > value[1] ? greaterMethod() : smallerMethod(), "RESULT", JOptionPane.PLAIN_MESSAGE);
        //System.out.println(value[0] > value[1] ? greaterMethod() : smallerMethod());
    }

    public String greaterMethod() {
        return "value1 is greater";
    }

    public String smallerMethod() {
        return "value2 is greater";
    }
}
