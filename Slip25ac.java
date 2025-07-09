import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Slip25ac {
    public static void main(String[] args) throws IOException {
        // Create a socket connection to the server
        Socket socket = new Socket("localhost", 12345);

        // Create input/output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Accept number input from the client terminal
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Send the number to the server
        out.println(number);

        // Read and display the factors received from the server
        System.out.println("Factors: " + in.readLine());

        socket.close();
        scanner.close();
    }
}
