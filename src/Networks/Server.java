package Networks;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {

    private JTextField userInput;
    private JTextArea chattingWindow;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() {
        super("Instant Messenger");
        //Creating a userInput on GUI
        userInput = new JTextField();
        //Cannot type anything unless you are connected
        userInput.setEditable(false);
        //Adding actionListener to the JTextField
        userInput.addActionListener(e -> {
            //Sending text we typed into the JTextField
            sendText(e.getActionCommand());
            //Setting chat to blank after sending the text
            userInput.setText("");
        });
        //Adding JTextField
        add(userInput, BorderLayout.NORTH);

        //Creating a JTextArea for chatWindow
        chattingWindow = new JTextArea();
        add(new JScrollPane(chattingWindow));
        setSize(300, 150);
        setVisible(true);
    }

    //Setting up and running the server
    public void startRunning() {
        try {
            //Assigning a port number and connection limit to the ServerSocket
            serverSocket = new ServerSocket(8000, 100);

            while (true) {
                try {
                    connectionAwaited();
                    setupStreams();
                    whileChatting();
                } catch (EOFException eofException) {
                    showMessage("\nServer ended the connection!");
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
    private void connectionAwaited() throws IOException {
        showMessage("Waiting for connection");
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
        showMessage("\nStreams are now setup!");
    }

    private void whileChatting() {
        String message = "You are now connected";
        showMessage(message);
        ableToType(true);
        do {
            try {
                message = (String) inStream.readObject();
                System.out.println("\n " + message);
            } catch (ClassNotFoundException | IOException classNotFoundException) {
                showMessage("\nUser sent invalid character");
            }
        } while (!message.equals("CLIENT - END"));
    }

    //To close streams and sockets after chatting
    private void closeOperation() {
        showMessage("\nClosing Connections");
        ableToType(false);
        try {
            outStream.close();
            inStream.close();
            socket.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendText(String message) {
        try {
            outStream.writeObject("Server: " + message);
            outStream.flush();
            showMessage("Server: " + message);
        } catch (IOException ioException) {
            chattingWindow.append("\nError: Cannot send message");
        }
    }

    //Updates chat window
    private void showMessage(final String text) {
        SwingUtilities.invokeLater(() -> chattingWindow.append(text));
    }

    //Allow user to type into the box
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(()->userInput.setEditable(tof));
    }

}
