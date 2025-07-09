import java.io.*;
import java.net.*;

public class Slip17bs {
    // Set your directory path here
    private static final String DIRECTORY_PATH = "C:/Users/DELL/Documents/advancedJava";  // Update this path to your desired directory

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server is running... Listening on port 5000...");

        while (true) {
            try (Socket socket = server.accept();
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Client connected!");
                String fileName = input.readLine();  // Read requested filename
                File file = new File(DIRECTORY_PATH, fileName);  // Use the directory path to locate the file

                if (file.exists() && file.isFile()) {
                    System.out.println("File found: " + fileName);
                    output.println("File Found. Contents:");
                    
                    try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = fileReader.readLine()) != null) {
                            output.println(line);  // Send file content
                        }
                    }
                } else {
                    System.out.println("File Not Found: " + fileName);
                    output.println("File Not Found");
                }
                output.println("END");  // Signal to client that transmission is done
            }
        }
    }
}