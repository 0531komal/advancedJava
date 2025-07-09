import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Slip25b {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DDL Executor");
        JTextField queryField = new JTextField();
        JButton createBtn = new JButton("Create Table");
        JButton alterBtn = new JButton("Alter Table");
        JButton dropBtn = new JButton("Drop Table");

        queryField.setBounds(50, 30, 300, 30);
        createBtn.setBounds(50, 80, 120, 30);
        alterBtn.setBounds(180, 80, 120, 30);
        dropBtn.setBounds(310, 80, 120, 30);

        frame.add(queryField);
        frame.add(createBtn);
        frame.add(alterBtn);
        frame.add(dropBtn);

        ActionListener action = e -> {
            String query = queryField.getText();
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(frame, "Query Executed");
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        };

        createBtn.addActionListener(action);
        alterBtn.addActionListener(action);
        dropBtn.addActionListener(action);

        frame.setSize(500, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}