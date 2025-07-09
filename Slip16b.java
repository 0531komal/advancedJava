import java.sql.*;

public class Slip16b{
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES (?, ?, ?)");
        String[][] students = {{"1", "Alice", "78"}, {"2", "Bob", "85"}, {"3", "Charlie", "90"}, {"4", "David", "88"}, {"5", "Eve", "95"}};
        for (String[] s : students) {
            ps.setInt(1, Integer.parseInt(s[0]));
            ps.setString(2, s[1]);
            ps.setDouble(3, Double.parseDouble(s[2]));
            ps.executeUpdate();
        }
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM Student ORDER BY sper DESC LIMIT 1");
        rs.next();
        System.out.println("Top Student: " + rs.getString(2) + " - " + rs.getDouble(3) + "%");
        con.close();
    }
}