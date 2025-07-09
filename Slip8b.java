import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Slip8b extends JLabel implements Runnable {
    private Thread t;

    public Slip8b() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Watch");
        Slip8b watch = new Slip8b();
        watch.setFont(new Font("Arial", Font.BOLD, 50));
        watch.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(watch);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}