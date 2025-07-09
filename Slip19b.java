// import javax.swing.*;
// import java.sql.*;

// public class Slip19b{
//     public static void main(String[] args) throws Exception {
//         // Set up the database connection
//         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

//         // Set up the JFrame and JTextFields
//         JFrame frame = new JFrame();
//         JTextField rno = new JTextField(10);
//         JTextField name = new JTextField(10);
//         JTextField per = new JTextField(10);
//         JButton btnLoad = new JButton("Load First Record");

//         // Set the layout and add components
//         frame.setLayout(new java.awt.GridLayout(4, 1));
//         frame.add(rno);
//         frame.add(name);
//         frame.add(per);
//         frame.add(btnLoad);

//         // ActionListener for button
//         btnLoad.addActionListener(e -> {
//             try {
//                 // Query the database to get the first student record
//                 ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Student LIMIT 1");

//                 // If record is found, populate the text fields
//                 if (rs.next()) {
//                     rno.setText(rs.getString(1));
//                     name.setText(rs.getString(2));
//                     per.setText(rs.getString(3));
//                 }
//             } catch (SQLException ex) {
//                 ex.printStackTrace();
//             }
//         });

//         // Frame settings
//         frame.setSize(300, 200);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
        
//         // Close the connection when the program is closed
//         frame.addWindowListener(new java.awt.event.WindowAdapter() {
//             public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                 try {
//                     con.close(); // Close the database connection
//                 } catch (SQLException ex) {
//                     ex.printStackTrace();
//                 }
//             }
//         });
//     }
// }

import java.sql.*;

public class Slip19b {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute Query to fetch first record
            ResultSet rs = stmt.executeQuery("SELECT id, sname, sper FROM Student LIMIT 1");

            // Display record if available
            if (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("sname"));
                System.out.println("Percent: " + rs.getDouble("sper"));
            } else {
                System.out.println("No records found.");
            }

            // Close connection
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
