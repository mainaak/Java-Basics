package componentsForMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchMethod extends CasesForSwitch {

    private JLabel statement;
    private JTextField switchChoice;
    private JButton run;

    public SwitchMethod() {
        super("Switch-Method");

        setLayout(new FlowLayout());
        statement = new JLabel("<html> Which class to run <br/> </html>");
        add(statement);
        switchChoice = new JTextField(5);
        add(switchChoice);
        run = new JButton("<html><br/>RUN</html>");
        add(run);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        Handler handler = new Handler();
        run.addActionListener(handler);
    }

    private class Handler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            new CasesForSwitch(switchChoice.getText());
        }
    }
}
