// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;

// public class Slip15b extends JFrame {

//     JTextField txtRNo, txtName, txtPer, txtClass;
//     JComboBox<String> genderBox;
//     JButton submit;

//     public Slip15b() {
//         setTitle("Student Entry Form");
//         setSize(400, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new GridLayout(6, 2, 10, 10));

//         // Form components
//         add(new JLabel("Roll No:"));
//         txtRNo = new JTextField();
//         add(txtRNo);

//         add(new JLabel("Name:"));
//         txtName = new JTextField();
//         add(txtName);

//         add(new JLabel("Percentage:"));
//         txtPer = new JTextField();
//         add(txtPer);

//         add(new JLabel("Gender:"));
//         genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
//         add(genderBox);

//         add(new JLabel("Class:"));
//         txtClass = new JTextField();
//         add(txtClass);

//         submit = new JButton("Submit");
//         add(submit);

//         // Submit button action
//         submit.addActionListener(e -> insertData());

//         setVisible(true);
//     }

//     void insertData() {
//         String rno = txtRNo.getText();
//         String name = txtName.getText();
//         String per = txtPer.getText();
//         String gender = genderBox.getSelectedItem().toString();
//         String cls = txtClass.getText();

//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection con = DriverManager.getConnection(
//                 "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

//             String query = "INSERT INTO student2 (RNo, SName, Per, Gender, Class) VALUES (?, ?, ?, ?, ?)";
//             PreparedStatement ps = con.prepareStatement(query);
//             ps.setInt(1, Integer.parseInt(rno));
//             ps.setString(2, name);
//             ps.setDouble(3, Double.parseDouble(per));
//             ps.setString(4, gender);
//             ps.setString(5, cls);

//             int result = ps.executeUpdate();
//             if (result > 0) {
//                 JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");
//             } else {
//                 JOptionPane.showMessageDialog(this, "Failed to insert record.");
//             }

//             con.close();
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         new Slip15b();
//     }
// }

import java.sql.*;
import java.util.Scanner;

public class Slip15b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Roll No: ");
        int rno = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Gender (Male/Female/Other): ");
        String gender = sc.nextLine();

        System.out.print("Enter Class: ");
        String cls = sc.nextLine();

        try {
            // JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

            // Insert query
            //String sql = "INSERT INTO student2 (RNo, SName, Per, Gender, Class) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement("INSERT INTO student2 (RNo, SName, Per, Gender, Class) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, rno);
            ps.setString(2, name);
            ps.setDouble(3, per);
            ps.setString(4, gender);
            ps.setString(5, cls);

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("✔ Record inserted successfully!");
            } else {
                System.out.println("✖ Failed to insert record.");
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}