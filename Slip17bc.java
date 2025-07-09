import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Slip17bc {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);  // Connect to the server running locally
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter file name to fetch from server: ");
            String fileName = scanner.nextLine();
            output.println(fileName);  // Send the filename request to the server

            String response;
            while (!(response = input.readLine()).equals("END")) {
                System.out.println(response);  // Print file contents or error message
            }
        }
    }
}