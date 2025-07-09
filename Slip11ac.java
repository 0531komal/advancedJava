import java.io.*;
import java.net.*;

public class Slip11ac {
    public static void main(String[] args) throws IOException {
        // Connect to the server running on localhost and port 12345
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to the server.");

        // Get the input stream to receive data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Read and print the data received from the server
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);  // Display server's response (client details)
        }

        // Close the connection
        socket.close();
    }
}
