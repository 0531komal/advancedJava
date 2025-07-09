import java.io.*;
import java.net.*;

public class Slip14bs {
    private static final String DIRECTORY_PATH = "C:/Users/DELL/Documents/advancedJava";  // Fixed directory path

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is running... Listening on port 5000...");

        while (true) {
            try (Socket socket = server.accept();
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Client connected!");
                String extension = input.readLine();  // Read requested file extension
                System.out.println("Client requested: " + extension);

                File folder = new File(DIRECTORY_PATH);  // Use fixed path
                String[] files = folder.list((dir, name) -> name.endsWith(extension));

                if (files != null && files.length > 0) {
                    System.out.println("Files found on server:");
                    for (String file : files) {
                        System.out.println(file);  // Print only on the server
                    }
                } else {
                    System.out.println("No files found for extension: " + extension);
                }
            }
        }
    }
}