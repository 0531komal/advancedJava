import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Slip14bc {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter file extension (e.g., .txt, .java): ");
            output.println(scanner.nextLine());  // Send extension request

            System.out.println("Request sent to server.");
        }
    }
}