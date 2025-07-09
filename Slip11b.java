// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;
// import javax.swing.table.DefaultTableModel;

// public class Slip11b extends JFrame {

//     JTextField txtFrom, txtTo;
//     JButton btnSearch;
//     JTable table;

//     public Slip11b() {
//         setTitle("Sales Report Between Dates");
//         setSize(700, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new BorderLayout());

//         JPanel topPanel = new JPanel();
//         topPanel.add(new JLabel("From (YYYY-MM-DD):"));
//         txtFrom = new JTextField(10);
//         topPanel.add(txtFrom);

//         topPanel.add(new JLabel("To (YYYY-MM-DD):"));
//         txtTo = new JTextField(10);
//         topPanel.add(txtTo);

//         btnSearch = new JButton("Search");
//         topPanel.add(btnSearch);

//         add(topPanel, BorderLayout.NORTH);

//         table = new JTable();
//         add(new JScrollPane(table), BorderLayout.CENTER);

//         btnSearch.addActionListener(e -> fetchData());

//         setVisible(true);
//     }

//     void fetchData() {
//         String fromDate = txtFrom.getText();
//         String toDate = txtTo.getText();

//         String[] columns = {"PID", "PName", "Qty", "Rate", "Amount", "SaleDate"};
//         DefaultTableModel model = new DefaultTableModel(columns, 0);
//         table.setModel(model);

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection con = DriverManager.getConnection(
//                 "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

//             String query = "SELECT * FROM Sales WHERE SaleDate BETWEEN ? AND ?";
//             PreparedStatement ps = con.prepareStatement(query);
//             ps.setDate(1, java.sql.Date.valueOf(fromDate));
//             ps.setDate(2, java.sql.Date.valueOf(toDate));

//             ResultSet rs = ps.executeQuery();
//             while (rs.next()) {
//                 Object[] row = {
//                     rs.getInt("PID"),
//                     rs.getString("PName"),
//                     rs.getInt("Qty"),
//                     rs.getDouble("Rate"),
//                     rs.getDouble("Amount"),
//                     rs.getDate("SaleDate")
//                 };
//                 model.addRow(row);
//             }

//             con.close();
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         new Slip11b();
//     }
// }

import java.sql.*;
import java.util.Scanner;

public class Slip11b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: from and to dates
        System.out.print("Enter FROM date (YYYY-MM-DD): ");
        String fromDate = scanner.nextLine();

        System.out.print("Enter TO date (YYYY-MM-DD): ");
        String toDate = scanner.nextLine();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp"
            );

            // SQL query
            String sql = "SELECT * FROM Sales WHERE SaleDate BETWEEN ? AND ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fromDate));
            ps.setDate(2, java.sql.Date.valueOf(toDate));

            // Execute query
            ResultSet rs = ps.executeQuery();

            // Display result
            System.out.println("PID | PName | Qty | Rate | Amount | SaleDate");            
            System.out.println("-----------------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("PID") + " | " +
                    rs.getString("PName") + " | " +
                    rs.getInt("Qty") + " | " +
                    rs.getDouble("Rate") + " | " +
                    rs.getDouble("Amount") + " | " +
                    rs.getDate("SaleDate")
                );
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}