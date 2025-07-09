import java.sql.*;

public class Slip12a{
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM emp;");
        rs.next();
        System.out.println("Total records: " + rs.getInt(1));
        con.close();
    }
}