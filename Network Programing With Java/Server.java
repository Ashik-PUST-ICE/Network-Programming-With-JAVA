import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(22222)) {
            System.out.println("Server Started..");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected..");

                // New Server Thread Start.....
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private final Socket clientSocket;

    ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {

            while (true) {
                // Read from client
                Object cMsg = ois.readObject();
                if (cMsg == null)
                    break;
                System.out.println("From Client: " + cMsg);

                // Convert to uppercase
                String serverMsg = ((String) cMsg).toUpperCase();

                // Send to client
                oos.writeObject(serverMsg);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
