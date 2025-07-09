<%@ page import="java.sql.*" %>
<%
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "password");
    PreparedStatement ps = con.prepareStatement("INSERT INTO Account VALUES (?, ?, ?)");
    ps.setInt(1, Integer.parseInt(request.getParameter("ANo")));
    ps.setString(2, request.getParameter("Type"));
    ps.setDouble(3, Double.parseDouble(request.getParameter("Bal")));
    ps.executeUpdate();
    out.println("<h3>Account Added</h3>");
    con.close();
%>
