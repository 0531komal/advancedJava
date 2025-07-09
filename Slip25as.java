import java.io.*;
import java.net.*;

public class Slip25as {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Receive the number from the client
        int num = Integer.parseInt(in.readLine());
        StringBuilder factors = new StringBuilder();

        // Calculate factors of the number
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors.append(i).append(" ");
            }
        }

        // Send the factors back to the client
        out.println(factors.toString());

        socket.close();
        serverSocket.close();
    }
}
