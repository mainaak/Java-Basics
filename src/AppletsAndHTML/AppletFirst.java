package AppletsAndHTML;

import java.applet.Applet;
import java.awt.*;

public class AppletFirst extends Applet {

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("This is a string on an Applet", 50, 50);
    }
}
