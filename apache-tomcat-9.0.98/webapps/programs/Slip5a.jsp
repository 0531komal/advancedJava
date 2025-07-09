<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <form method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>

    <%
        String numStr = request.getParameter("number");
        if (numStr != null && !numStr.isEmpty()) {
            int num = Integer.parseInt(numStr);
            int firstDigit = Integer.parseInt(String.valueOf(numStr.charAt(0)));
            int lastDigit = num % 10;
            int sum = firstDigit + lastDigit;
    %>
        <p style="color:red; font-size:18px;">Sum of first and last digits: <%= sum %></p>
    <%
        }
    %>
</body>
</html>
