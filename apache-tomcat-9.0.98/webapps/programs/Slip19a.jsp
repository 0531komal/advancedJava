<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>Greet User</title>
    <!-- <style>
        body { font-family: Arial, sans-serif; text-align: center; margin: 50px; }
        form { display: inline-block; padding: 20px; border: 1px solid black; background: #f9f9f9; }
        h2 { color: #333; }
    </style> -->
</head>
<body>
    <h2>Greet User</h2>
    <form method="post">
        <label>Enter Your Name:</label>
        <input type="text" name="username" required>
        <input type="submit" value="Greet Me">
    </form>

    <%
        // Get the user input
        String username = request.getParameter("username");

        if (username != null && !username.trim().isEmpty()) {
            // Get current hour from server machine
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            String greeting;

            // Determine greeting based on time
            if (hour >= 5 && hour < 12) {
                greeting = "Good Morning";
            } else if (hour >= 12 && hour < 17) {
                greeting = "Good Afternoon";
            } else if (hour >= 17 && hour < 21) {
                greeting = "Good Evening";
            } else {
                greeting = "Good Night";
            }
    %>
        <h3 style="color: green;"><%= greeting %>, <%= username %>! 😊</h3>
    <%
        }
    %>
</body>
</html>
