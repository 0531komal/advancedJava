import javax.swing.*;
import java.awt.*;

public class Slip30b extends JPanel implements Runnable {
    private int x = 0; // Initial position of the car
    private Thread thread;

    public Slip30b() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(x, 100, 100, 50);

        g.setColor(Color.BLACK);
        g.fillOval(x + 10, 150, 20, 20); // Left wheel
        g.fillOval(x + 70, 150, 20, 20); // Right wheel
    }

    @Override
    public void run() {
        while (true) {
            // Update the x position for the car movement
            x = (x + 10) % getWidth(); // Moves the car and wraps it around
            repaint(); // Repaint the panel to show the new position

            try {
                Thread.sleep(100); // Delay to control the speed of the animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Car");
        Slip30b movingCarPanel = new Slip30b();
        frame.add(movingCarPanel);
        frame.setSize(400, 300); // Set the size of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        movingCarPanel.thread = new Thread(movingCarPanel);
        movingCarPanel.thread.start();
    }
}