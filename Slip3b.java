import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Slip3b extends JPanel implements Runnable {
    private int x = 50, y = 50, dx = 5, dy = 5;
    private Color ballColor = Color.RED;
    private Thread t;
    private Random random = new Random();

    public Slip3b() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ballColor);
        g.fillOval(x, y, 30, 30);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;

            if (x < 0 || x > getWidth() - 30) {
                dx = -dx;
                ballColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }
            if (y < 0 || y > getHeight() - 30) {
                dy = -dy;
                ballColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            }

            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.add(new Slip3b());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
