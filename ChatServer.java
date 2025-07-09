import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String msgIn, msgOut;
        while (true) {
            msgIn = in.readLine();
            if (msgIn.equalsIgnoreCase("exit")) break;
            System.out.println("Client: " + msgIn);

            System.out.print("You: ");
            msgOut = keyboard.readLine();
            out.println(msgOut);
        }

        socket.close();
        server.close();
    }
}
