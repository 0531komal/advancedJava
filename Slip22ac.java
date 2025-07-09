import java.io.*;
import java.net.*;

public class Slip22ac {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server Date & Time: " + in.readLine());
        socket.close();
    }
}
