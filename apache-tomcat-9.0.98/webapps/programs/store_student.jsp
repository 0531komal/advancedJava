<%@ page import="java.sql.*" %>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slips_db", "root", "rootp");

    String name = request.getParameter("name");
    String age = request.getParameter("age");

    PreparedStatement ps = con.prepareStatement("INSERT INTO student1 (name, age) VALUES (?, ?)");
    ps.setString(1, name);
    ps.setString(2, age);
    ps.executeUpdate();

    out.print("Student added successfully!");
    con.close();
} catch (Exception e) {
    out.print("Error: " + e.getMessage());
}
%>