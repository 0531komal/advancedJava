import javax.swing.*;
import java.awt.*;

public class Slip5b extends JPanel implements Runnable {
    private String currentColor = "RED";
    private Thread t;

    public Slip5b() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(50, 50, 100, 300);

        if ("RED".equals(currentColor)) g.setColor(Color.RED);
        else g.setColor(Color.GRAY);
        g.fillOval(75, 75, 50, 50);

        if ("YELLOW".equals(currentColor)) g.setColor(Color.YELLOW);
        else g.setColor(Color.GRAY);
        g.fillOval(75, 175, 50, 50);

        if ("GREEN".equals(currentColor)) g.setColor(Color.GREEN);
        else g.setColor(Color.GRAY);
        g.fillOval(75, 275, 50, 50);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                switch (currentColor) {
                    case "RED" -> currentColor = "YELLOW";
                    case "YELLOW" -> currentColor = "GREEN";
                    case "GREEN" -> currentColor = "RED";
                }
                repaint();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Signal");
        frame.add(new Slip5b());
        frame.setSize(200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
