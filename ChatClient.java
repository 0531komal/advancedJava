import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String msgIn, msgOut;
        while (true) {
            System.out.print("You: ");
            msgOut = keyboard.readLine();
            out.println(msgOut);
            if (msgOut.equalsIgnoreCase("exit")) break;

            msgIn = in.readLine();
            System.out.println("Server: " + msgIn);
        }

        socket.close();
    }
}