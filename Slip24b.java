import java.sql.*;
import java.util.Scanner;

public class Slip24b {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");
        Scanner sc = new Scanner(System.in);
        Statement stmt = con.createStatement();

        while (true) {
            System.out.println("1.Insert 2.Update 3.Delete 4.Search 5.Display 6.Exit");
            switch (sc.nextInt()) {
                case 1:
                    stmt.execute("INSERT INTO Employee (ENo, EName, Salary, Desg) VALUES (101, 'Mike', 60000, 'Manager')");
                    break;

                case 2:
                    stmt.execute("UPDATE Employee SET Salary=70000 WHERE ENo=101");
                    break;

                case 3:
                    stmt.execute("DELETE FROM Employee WHERE ENo=101");
                    break;

                case 4: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Employee WHERE ENo=101");
                    while (rs.next()) {
                        // Printing all fields for the Employee with ENo=101
                        System.out.println("ENo: " + rs.getInt(1) + ", EName: " + rs.getString(2) + 
                                           ", Salary: " + rs.getDouble(3) + ", Desg: " + rs.getString(4));
                    }
                    break;
                }

                case 5: {
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
                    while (rs.next()) {
                        // Printing all fields for all employees
                        System.out.println("ENo: " + rs.getInt(1) + ", EName: " + rs.getString(2) + 
                                           ", Salary: " + rs.getDouble(3) + ", Desg: " + rs.getString(4));
                    }
                    break;
                }

                case 6:
                    con.close();
                    return; // Exit the program
            }
        }
    }
}