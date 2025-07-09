import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Slip10b extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Product Details</title></head><body>");
        out.println("<h2>Product List</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ProdCode</th><th>Product Name</th><th>Price</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("ProdCode") + "</td>");
                out.println("<td>" + rs.getString("PName") + "</td>");
                out.println("<td>" + rs.getDouble("Price") + "</td>");
                out.println("</tr>");
            }

            out.println("</table></body></html>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}