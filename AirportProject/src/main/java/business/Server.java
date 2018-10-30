package business;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Server implements Runnable {
    private static final Log LOGGER = LogFactory.getLog(Server.class);

   private ServerSocket serverSocket;

   public Server(int port) throws IOException{
       this.serverSocket = new ServerSocket(port);
       new Thread(this).start();
   }
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    Socket clientSocket;
                    clientSocket = serverSocket.accept();
                    Session cThread = new Session(clientSocket);
                    cThread.start();
                }
            } catch (IOException e) {
                LOGGER.error("", e);
            }
        }
    }
}
