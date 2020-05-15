package AppletsAndNetworks;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WebBrowser extends JFrame {

    private JTextField addressBar;
    private JEditorPane windowOfBrowser;

    public <T> WebBrowser(T a){
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public WebBrowser() {
        super("Basic");

        addressBar = new JTextField("Enter URL Here:");
        addressBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadingMethod(e.getActionCommand());
            }
        });
        add(addressBar, BorderLayout.NORTH);

        windowOfBrowser = new JEditorPane();
        windowOfBrowser.setBackground(Color.WHITE);
        windowOfBrowser.setEditable(false);
        windowOfBrowser.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
                    loadingMethod(e.getURL().toString());
                }
            }
        });

        add(new JScrollPane(windowOfBrowser), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    private void loadingMethod(String enteredUrl) {
        try {
            windowOfBrowser.setPage(enteredUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addressBar.setText(enteredUrl);
    }
}
