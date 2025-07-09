import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Slip23a extends JFrame {

    public Slip23a() {
        setTitle("College Details");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Column Names
        String[] columnNames = {"CID", "CName", "Address", "Year"};

        // Sample Data
        String[][] data = {
            {"C101", "Green Valley College", "Pune", "1995"},
            {"C102", "Sunrise Institute", "Mumbai", "2001"},
            {"C103", "Bright Future College", "Delhi", "2010"},
            {"C104", "Techno Campus", "Bangalore", "2005"}
        };

        // Create Table Model and JTable
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        // Add to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Slip23a frame = new Slip23a();
            frame.setVisible(true);
        });
    }
}