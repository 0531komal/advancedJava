<%@ page session="true" %>
<html>
<head><title>Final Bill</title></head>
<body>
    <h2>Final Bill</h2>

    <%
        double page1Total = session.getAttribute("page1Total") != null ? (double) session.getAttribute("page1Total") : 0;
        double page2Total = session.getAttribute("page2Total") != null ? (double) session.getAttribute("page2Total") : 0;
        double grandTotal = page1Total + page2Total;
    %>

    <h3>Page 1 Total: $<%= page1Total %></h3>
    <h3>Page 2 Total: $<%= page2Total %></h3>
    <h2 style="color:red;">Grand Total: $<%= grandTotal %></h2>

    <form action="Slip9b-1.jsp">
        <input type="submit" value="New Purchase">
    </form>
</body>
</html>