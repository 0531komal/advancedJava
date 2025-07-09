import java.sql.*;

public class Slip8a {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp"
            );

            // Query to find names starting with 'A'
            String query = "SELECT EName FROM emp WHERE EName LIKE 'A%'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Employees whose names start with 'A':");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println(rs.getString("EName"));
            }

            if (!found) {
                System.out.println("No employee names starting with 'A' found.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}