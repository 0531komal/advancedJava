import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Slip28b extends JFrame {

    Choice empNoChoice;
    JTable empTable;
    DefaultTableModel tableModel;

    Connection con;

    public Slip28b() {
        setTitle("Employee Detail Viewer");
        setSize(600, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select ENo:"));
        empNoChoice = new Choice();
        topPanel.add(empNoChoice);
        add(topPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"ENo", "EName", "Sal"};
        tableModel = new DefaultTableModel(columns, 0);
        empTable = new JTable(tableModel);
        add(new JScrollPane(empTable), BorderLayout.CENTER);

        // DB Setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

            // Populate EmpNo in Choice
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT ENo FROM emp");
            while (rs.next()) {
                empNoChoice.add(rs.getString("ENo"));
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "DB Error: " + e.getMessage());
        }

        // Choice listener
        empNoChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                showEmployeeDetails(empNoChoice.getSelectedItem());
            }
        });

        setVisible(true);
    }

    void showEmployeeDetails(String empNo) {
        try {
            tableModel.setRowCount(0); // Clear previous rows
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM emp WHERE ENo = ?");
            ps.setString(1, empNo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] row = {
                    rs.getString("ENo"),
                    rs.getString("EName"),
                    rs.getDouble("Sal")
                };
                tableModel.addRow(row);
            }

            rs.close();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error fetching employee: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Slip28b();
    }
}