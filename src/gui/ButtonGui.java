package gui;

import componentsForMain.SwitchMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGui extends JFrame {

    private JButton regularButton;

    public ButtonGui() {
        super("Running-Program");
        setLayout(new FlowLayout());

        regularButton = new JButton("Run Program");
        add(regularButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        HandlerClass handlerClass = new HandlerClass();
        regularButton.addActionListener(handlerClass);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            new SwitchMethod();
        }
    }
}
