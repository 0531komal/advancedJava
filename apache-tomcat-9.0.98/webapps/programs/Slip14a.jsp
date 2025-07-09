<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voter Eligibility Check</title>
    <!-- <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        form {
            display: inline-block;
            padding: 20px;
            border: 1px solid black;
            background-color: #f9f9f9;
        }
        h2 {
            color: #333;
        }
    </style> -->
</head>
<body>
    <h2>Check Voter Eligibility</h2>
    <form method="post">
        <label>Enter Name:</label>
        <input type="text" name="name" required><br><br>
        
        <label>Enter Age:</label>
        <input type="number" name="age" required><br><br>
        
        <input type="submit" value="Check Eligibility">
    </form>

    <%
        // Fetch user input
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        if (name != null && ageStr != null) {
            int age = Integer.parseInt(ageStr);
            if (age >= 18) {
    %>
                <h3 style="color: green;">Hello <%= name %>, You are eligible to vote! ✅</h3>
    <%
            } else {
    %>
                <h3 style="color: red;">Sorry <%= name %>, You are NOT eligible to vote! ❌</h3>
    <%
            }
        }
    %>
</body>
</html>
