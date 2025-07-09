import java.sql.*;

public class Slip27b {
    public static void main(String[] args) throws Exception {
        // Establishing the connection to the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

        // Creating a scrollable statement
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Executing the query to retrieve all the records from the Teacher table
        ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");

        // Move the cursor to the end of the result set to traverse backward
        rs.afterLast();
        
        // Printing the result in reverse order using previous()
        while (rs.previous()) {
            System.out.println("TName: " + rs.getString("TName") + " - Salary: " + rs.getDouble("Salary") + " - Subject: " + rs.getString("Sub"));
        }

        // Closing the connection
        con.close();
    }
}