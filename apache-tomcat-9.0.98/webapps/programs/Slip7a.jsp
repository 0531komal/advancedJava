<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>
    <form method="post">
        Enter your Email ID: <input type="text" name="email">
        <input type="submit" value="Validate">
    </form>

    <%
        String email = request.getParameter("email");
        if (email != null && !email.isEmpty()) {
            String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (email.matches(emailPattern)) {
    %>
                <p style="color:green;">Valid Email ID</p>
    <%
            } else {
    %>
                <p style="color:red;">Invalid Email ID</p>
    <%
            }
        }
    %>
</body>
</html>
