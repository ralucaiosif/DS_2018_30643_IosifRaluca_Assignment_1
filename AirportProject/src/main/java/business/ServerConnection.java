package business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection {
    private static final Log LOGGER = LogFactory.getLog(ServerConnection.class);

    private String host;
    private int port;

    public ServerConnection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String sendRequest(String messageToSend) throws IOException {
        Socket clientSocket = new Socket(host, port);
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
        outToServer.writeObject(messageToSend);

        String response;
        try {
            response = (String)inFromServer.readObject();
        } catch (ClassNotFoundException e) {
            response = null;
            LOGGER.error("", e);
        }

        outToServer.close();
        inFromServer.close();
        clientSocket.close();

        return response;
    }
}
