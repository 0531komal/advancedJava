import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Slip6a extends JFrame {
    private JLabel imageLabel;
    private Timer timer;
    private boolean isVisible = true;

    public Slip6a() {
        setTitle("Blinking Image");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load image (make sure image file is in the same directory or provide full path)
        ImageIcon icon = new ImageIcon("image.jpg");  // Replace with your image file name
        imageLabel = new JLabel(icon);
        add(imageLabel);

        // Timer to toggle visibility every 500ms
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isVisible = !isVisible;
                imageLabel.setVisible(isVisible);
            }
        });
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Slip6a();
    }
}