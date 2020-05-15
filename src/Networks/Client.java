package Networks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {
    private JTextField userMessage;
    private JTextArea chatWindow;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private String message = "";
    private String serverIP;
    private Socket socket;

    public Client(String host) {
        super("CLIENT");
        serverIP = host;
        userMessage = new JTextField();
        userMessage.setEditable(false);
        userMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(e.getActionCommand());
                userMessage.setText("");
            }
        });

        add(userMessage, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);
        setSize(300, 150);
        setVisible(true);
    }

    public void startRunning() {
        try {
            connectToServer();
            setupStreams();
            whileChatting();
        } catch (EOFException eofException) {
            showMessage("\n Client terminated the connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeOp();
        }
    }

    //Connect to server
    private void connectToServer() throws IOException {
        showMessage("Attempting Connection... \n");
        socket = new Socket(InetAddress.getByName(serverIP), 6789);
        showMessage("Connected to:" + socket.getInetAddress().getHostName());
    }

    //Setup streams
    private void setupStreams() throws IOException {
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.flush();

        inputStream = new ObjectInputStream(socket.getInputStream());
        showMessage("\nYour streams are now good to go!\n");
    }

    //While chatting with server
    private void whileChatting() throws IOException {
        ableToType(true);
        do {
            try {
                message = (String) inputStream.readObject();
                showMessage("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                showMessage("\nObject Type? at Client");
            }
        } while (!message.equals("Server - END"));
    }

    private void closeOp() {
        showMessage("\n Closing Operation...");
        ableToType(false);
        try {
            outputStream.close();
            inputStream.close();
            socket.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try {
            outputStream.writeObject("Client - " + message);
            outputStream.flush();
            showMessage("\nClient - " + message);
        } catch (IOException ioException) {
            chatWindow.append("\nSomething Went wrong...");
        }
    }

    private void showMessage(final String m) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatWindow.append(m);
            }
        });
    }

    private void ableToType(final Boolean tof) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userMessage.setEditable(tof);
            }
        });
    }
}