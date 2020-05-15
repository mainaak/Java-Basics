package Networks;

import javax.swing.*;

public class ServerMain {

    public ServerMain() {
        Server serverObj = new Server();
        serverObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverObj.startRunning();
    }
}
