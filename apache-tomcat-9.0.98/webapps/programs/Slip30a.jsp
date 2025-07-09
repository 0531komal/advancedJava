<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reverse String</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin: 50px; }
        form { display: inline-block; padding: 20px; border: 1px solid black; background: #f9f9f9; }
        h2 { color: #333; }
        .output { color: red; font-size: 18px; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Enter a String</h2>
    <form method="post">
        <input type="text" name="inputString" required>
        <input type="submit" value="Reverse">
    </form>

<%
    // Fetch input string from user
    String inputString = request.getParameter("inputString");

    if (inputString != null && !inputString.trim().isEmpty()) {
        // Reverse the string using StringBuilder
        String reversedString = new StringBuilder(inputString).reverse().toString();
%>
        <h3 class="output">Reversed String: <%= reversedString %></h3>
<%
    }
%>
</body>
</html>
