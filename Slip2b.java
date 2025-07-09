import javax.swing.*;
import java.awt.*;

public class Slip2b extends JPanel implements Runnable {
    private int x1 = 200;
    private Thread t;

    public Slip2b() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (x1 > 100) {
                x1 -= 10;  // Move the flag to the left
                repaint(); // Repaint the panel
                Thread.sleep(200);  // Sleep for 200 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillRect(x1, 50, 100, 20);  // Top stripe
        g.setColor(Color.WHITE);
        g.fillRect(x1, 70, 100, 20);  // Middle stripe
        g.setColor(Color.GREEN);
        g.fillRect(x1, 90, 100, 20);  // Bottom stripe
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flag Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new Slip2b());
        frame.setVisible(true);
    }
}
