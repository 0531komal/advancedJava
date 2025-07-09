<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Number to Words</title>
    <style>
        /* body { font-family: Arial, sans-serif; text-align: center; margin: 50px; }
        form { display: inline-block; padding: 20px; border: 1px solid black; background: #f9f9f9; }
        h2 { color: #333; } */
        .output { color: red; font-size: 18px; font-weight: bold; }
    </style>
</head>
<body>
    <h2>Enter a Number</h2>
    <form method="post">
        <input type="number" name="num" required>
        <input type="submit" value="Convert">
    </form>

<%
    // Fetch user input
    String numStr = request.getParameter("num");

    if (numStr != null && !numStr.trim().isEmpty()) {
        // Number to words mapping
        String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        StringBuilder result = new StringBuilder();

        // Convert each digit to words
        for (char digit : numStr.toCharArray()) {
            result.append(words[Character.getNumericValue(digit)]).append(" ");
        }
%>
        <h3 class="output"><%= result.toString().trim() %></h3>
<%
    }
%>
</body>
</html>
