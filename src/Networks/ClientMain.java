package Networks;

import javax.swing.*;

public class ClientMain {
    public ClientMain(){
        Client clientObj = new Client("127.0.0.1");
        clientObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientObj.startRunning();
    }
}
