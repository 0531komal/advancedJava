<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher Details</title>
    <!-- <style>
        body { font-family: Arial; text-align: center; padding: 40px; }
        form { border: 1px solid black; padding: 20px; display: inline-block; background-color: #f9f9f9; }
        table { margin-top: 20px; border-collapse: collapse; width: 60%; margin-left: auto; margin-right: auto; }
        td, th { border: 1px solid black; padding: 10px; }
        th { background-color: #ddd; }
    </style> -->
</head>
<body>
    <h2>Enter Teacher Details</h2>
    <form method="post">
        <label>Teacher ID:</label><br>
        <input type="text" name="tid" required><br><br>

        <label>Name:</label><br>
        <input type="text" name="tname" required><br><br>

        <label>Designation:</label><br>
        <select name="desg" required>
            <option value="Professor">Professor</option>
            <option value="Associate Professor">Associate Professor</option>
            <option value="Assistant Professor">Assistant Professor</option>
            <option value="Lecturer">Lecturer</option>
        </select><br><br>

        <label>Subject:</label><br>
        <input type="text" name="subject" required><br><br>

        <label>Qualification:</label><br>
        <input type="text" name="qualification" required><br><br>

        <input type="submit" value="Submit">
    </form>

<%
    String tid = request.getParameter("tid");
    String tname = request.getParameter("tname");
    String desg = request.getParameter("desg");
    String subject = request.getParameter("subject");
    String qualification = request.getParameter("qualification");

    if (tid != null && tname != null && desg != null && subject != null && qualification != null) {
%>
    <h2>Teacher Details Entered:</h2>
    <table>
        <tr><th>Teacher ID</th><td><%= tid %></td></tr>
        <tr><th>Name</th><td><%= tname %></td></tr>
        <tr><th>Designation</th><td><%= desg %></td></tr>
        <tr><th>Subject</th><td><%= subject %></td></tr>
        <tr><th>Qualification</th><td><%= qualification %></td></tr>
    </table>
<%
    }
%>
</body>
</html>
