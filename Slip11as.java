import java.io.*;
import java.net.*;

public class Slip11as {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client connection...");

        // Wait for client to connect
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        // Get client machine details
        InetAddress clientAddress = socket.getInetAddress();
        String clientName = clientAddress.getHostName();
        String clientIP = clientAddress.getHostAddress();

        // Send client machine details to the client
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Client Name: " + clientName);
        out.println("Client IP Address: " + clientIP);

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}
