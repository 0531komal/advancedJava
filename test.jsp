<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation</title>
</head>
<body>
    <h2>Email Validation Form</h2>
    <form method="post" action="">
        Email: <input type="text" name="email" required><br>
        <input type="submit" value="Validate">
    </form>

    <%
        String email = request.getParameter("email");
        if (email != null) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
            if (email.matches(emailRegex)) {
                out.print("<p style='color: green;'>Email is valid!</p>");
            } else {
                out.print("<p style='color: red;'>Invalid email format!</p>");
            }
        }
    %>
</body>
</html>