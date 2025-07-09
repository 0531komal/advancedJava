import javax.swing.*;
import java.awt.*;

public class Slip7b extends JFrame implements Runnable {
    private JTextField textField = new JTextField();
    private JButton startButton = new JButton("Start");
    private Thread t;

    public Slip7b() {
        setLayout(new FlowLayout());
        add(textField);
        add(startButton);
        textField.setColumns(20);

        startButton.addActionListener(e -> {
            if (t == null || !t.isAlive()) {
                t = new Thread(Slip7b.this);
                t.start();
            }
        });

        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            textField.setText(String.valueOf(i));
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Slip7b();
    }
}