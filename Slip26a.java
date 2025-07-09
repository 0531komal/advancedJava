import java.sql.*;

public class Slip26a{
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        ResultSet rs = con.createStatement().executeQuery("SELECT CName FROM College");
        while (rs.next()) System.out.println(rs.getString(1));
        con.close();
    }
}