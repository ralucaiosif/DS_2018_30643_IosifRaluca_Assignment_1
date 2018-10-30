package business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Session extends Thread {

    private static final Log LOGGER = LogFactory.getLog(Session.class);

    private Socket clientSocket;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;

    public Session(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            inFromClient = new ObjectInputStream(this.clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(this.clientSocket.getOutputStream());
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    @Override
    public void run(){
        String messageReceived;
        try {
            messageReceived = (String) inFromClient.readObject();
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.error("", e);
        }

    }
}
