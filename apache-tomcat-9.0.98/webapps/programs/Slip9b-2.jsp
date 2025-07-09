<%@ page session="true" %>
<html>
<head><title>Shopping Page 2</title></head>
<body>
    <h2>Shopping Mall - Page 2</h2>
    <form method="post">
        <input type="checkbox" name="items" value="150"> Product C ($150) <br>
        <input type="checkbox" name="items" value="250"> Product D ($250) <br><br>
        <input type="submit" value="Show Total & Get Bill">
    </form>

    <%
        double page2Total = 0;
        String[] items = request.getParameterValues("items");
        if (items != null) {
            for (String price : items) {
                page2Total += Double.parseDouble(price);
            }
            session.setAttribute("page2Total", page2Total);
        } else {
            page2Total = session.getAttribute("page2Total") != null ? (double) session.getAttribute("page2Total") : 0;
        }
    %>

    <h3>Page 2 Total: $<%= page2Total %></h3>

    <form action="Slip9b-3.jsp">
        <input type="submit" value="See Final Bill">
    </form>
</body>
</html>