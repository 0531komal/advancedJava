<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Entry</title>
    <style>
        body { font-family: Arial; text-align: center; margin: 50px; }
        form { border: 1px solid black; display: inline-block; padding: 20px; background: #f0f0f0; }
        table { margin-top: 30px; border-collapse: collapse; width: 60%; margin-left: auto; margin-right: auto; }
        th, td { border: 1px solid black; padding: 8px; }
        th { background-color: #ddd; }
    </style>
</head>
<body>
    <h2>Enter Account Details</h2>
    <form method="post">
        <label>Account No:</label>
        <input type="number" name="ano" required><br><br>
        
        <label>Type:</label>
        <input type="text" name="type" required><br><br>
        
        <label>Balance:</label>
        <input type="number" step="0.01" name="bal" required><br><br>
        
        <input type="submit" value="Submit">
    </form>

<%
    String ano = request.getParameter("ano");
    String type = request.getParameter("type");
    String bal = request.getParameter("bal");

    // Database connection
    String url = "jdbc:mysql://localhost:3306/slips_db";
    String user = "root";
    String pass = "rootp"; // Change if password is set

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, pass);
        stmt = conn.createStatement();

        // Insert if form was submitted
        if (ano != null && type != null && bal != null) {
            String insertQuery = "INSERT INTO account VALUES (" + ano + ", '" + type + "', " + bal + ")";
            stmt.executeUpdate(insertQuery);
        }

        // Fetch and display all records
        rs = stmt.executeQuery("SELECT * FROM account");
%>
        <h2>Account Records</h2>
        <table>
            <tr>
                <th>Account No</th>
                <th>Type</th>
                <th>Balance</th>
            </tr>
<%
        while (rs.next()) {
%>
            <tr>
                <td><%= rs.getInt("ano") %></td>
                <td><%= rs.getString("type") %></td>
                <td><%= rs.getDouble("bal") %></td>
            </tr>
<%
        }
    } catch(Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
        </table>
</body>
</html>
