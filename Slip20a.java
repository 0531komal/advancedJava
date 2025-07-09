import java.sql.*;

public class Slip20a{
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide Employee ID.");
            return;
        }
        int eno = Integer.parseInt(args[0]);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE ENo = ?");
        ps.setInt(1, eno);
        int rows = ps.executeUpdate();
        System.out.println(rows + " record(s) deleted.");
        con.close();
    }
}