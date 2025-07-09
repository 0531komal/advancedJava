<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    // Fetch user input
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if username and password are the same
    if (username != null && password != null && username.equals(password)) {
        response.sendRedirect("Slip16a-Login.html"); // Redirect to success page
    } else {
        response.sendRedirect("Slip16a-Error.html"); // Redirect to error page
    }
%>