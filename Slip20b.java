import javax.swing.*;
import java.awt.*;

public class Slip20b extends JPanel implements Runnable {
    private Thread t;

    public Slip20b() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(150, 50, 100, 150); // Left
        g.drawLine(150, 50, 200, 150); // Right
        g.drawRect(100, 150, 100, 100); // Base
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Temple Drawing");
        frame.add(new Slip20b());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
