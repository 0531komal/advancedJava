import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class Slip1bserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        JFrame frame = new JFrame("Chat Server");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JTextField textField = new JTextField(20);
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(textField);
        panel.add(sendButton);

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        sendButton.addActionListener(e -> {
            String msg = textField.getText();
            textArea.append("Server: " + msg + "\n");
            out.println(msg);
            textField.setText("");
        });

        String msg;
        while ((msg = in.readLine()) != null) {
            textArea.append("Client: " + msg + "\n");
        }
    }
}