import java.io.*;
import java.net.*;

public class Slip3ac {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        int number = 29; // Example number
        out.println(number);
        String response = in.readLine();
        System.out.println("Server Response: " + response);

        socket.close();
    }
}
