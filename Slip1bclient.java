import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;

public class Slip1bclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        JFrame frame = new JFrame("Chat Client");
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
            textArea.append("Client: " + msg + "\n");
            out.println(msg);
            textField.setText("");
        });

        String msg;
        while ((msg = in.readLine()) != null) {
            textArea.append("Server: " + msg + "\n");
        }
    }
}