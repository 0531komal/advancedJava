import java.sql.*;

public class Slip4a {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  // This is for version 8.x.x and above.
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE sname LIKE 'S%'");
        int rows = ps.executeUpdate();
        System.out.println(rows + " records deleted.");
        con.close();
    }
}
