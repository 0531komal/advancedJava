import javax.swing.*;
import java.awt.*;

public class Slip1a extends JFrame implements Runnable {
    private JLabel label;
    private boolean scrollLeftToRight = true;  // Flag to control scrolling direction

    public Slip1a() {
        // Initialize the JLabel with some text
        label = new JLabel("  Scrolling Text  ");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        
        // Create and start a new thread
        Thread t = new Thread(this);
        t.start();
        
        // Set up the JFrame
        add(label);
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            int directionChangeCounter = 0;  // Count the number of scroll cycles before changing direction

            // Loop to continuously scroll the text in both directions
            while (true) {
                String text = label.getText();
                
                if (scrollLeftToRight) {
                    // Scroll from left to right
                    label.setText(text.substring(1) + text.charAt(0));
                } else {
                    // Scroll from right to left
                    label.setText(text.charAt(text.length() - 1) + text.substring(0, text.length() - 1));
                }

                // After 20 cycles, toggle direction
                directionChangeCounter++;
                if (directionChangeCounter >= 20) {
                    scrollLeftToRight = !scrollLeftToRight;
                    directionChangeCounter = 0;  // Reset counter
                }

                // Sleep for 300 milliseconds to control the speed of the animation
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Slip1a();  // Create and display the JFrame
    }
}