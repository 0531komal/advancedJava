import java.net.*;
import java.io.*;
import java.util.Date;

public class Slip22as {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(new Date().toString());

        socket.close();
        serverSocket.close();
    }
}
