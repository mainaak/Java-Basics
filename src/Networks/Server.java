package Networks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {

    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() {
        super("SERVER");
        //Creating a userInput on GUI
        userText = new JTextField();
        //Cannot type anything unless you are connected
        userText.setEditable(false);
        //Adding actionListener to the JTextField
        userText.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage(e.getActionCommand());
                        userText.setText("");
                    }
                }
        );

                //Adding JTextField
                add(userText, BorderLayout.NORTH);

        //Creating a JTextArea for chatWindow
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(300, 150);
        setVisible(true);
    }

    //Setting up and running the server
    public void startRunning() {
        try {
            //Assigning a port number and connection limit to the ServerSocket
            serverSocket = new ServerSocket(6789, 100);

            while (true) {
                try {
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                } catch (EOFException eofException) {
                    showMessage("\n Server ended the connection! ");
                } finally {
                    //Close all the open processes and sockets
                    closeOperation();
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    //Wait for connection
    private void waitForConnection() throws IOException {
        showMessage("Waiting for connection...\n");
        socket = serverSocket.accept();
        showMessage("Now connected to " + socket.getInetAddress().getHostName());
    }

    //Setup the streams to send and receive data
    private void setupStreams() throws IOException {
        //Setting data to go out of the computer
        outStream = new ObjectOutputStream(socket.getOutputStream());
        outStream.flush();

        //Setting data to come into our system
        inStream = new ObjectInputStream(socket.getInputStream());
        showMessage("\nStreams are now setup!\n");
    }

    private void whileChatting() throws IOException {
        String message = "You are now connected";
        showMessage(message);
        ableToType(true);
        do {
            try {
                message = (String) inStream.readObject();
                showMessage("\n" + message);
            } catch (ClassNotFoundException classNotFoundException) {
                showMessage("\nUser sent invalid character");
            }
        } while (!message.equals("Client - END"));
    }

    //To close streams and sockets after chatting
    private void closeOperation() {
        showMessage("\nClosing Connections...\n");
        ableToType(false);
        try {
            outStream.close();
            inStream.close();
            socket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try {
            outStream.writeObject("Server - " + message);
            outStream.flush();
            showMessage("\nServer - " + message);
        } catch (IOException ioException) {
            chatWindow.append("\nError: Cannot send message");
        }
    }

    //Updates chat window
    private void showMessage(final String text) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        chatWindow.append(text);
                    }
                }
        );
    }

    //Allow user to type into the box
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userText.setEditable(true);
            }
        });

    }
}
