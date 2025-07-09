import java.sql.*;

public class Slip9a {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        Statement stmt = con.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS Emp (ENo INT, EName VARCHAR(50), Sal DOUBLE)");
        PreparedStatement ps = con.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");
        ps.setInt(1, 101);
        ps.setString(2, "John");
        ps.setDouble(3, 50000);
        ps.executeUpdate();
        System.out.println("Record inserted.");
        con.close();
    }
}
