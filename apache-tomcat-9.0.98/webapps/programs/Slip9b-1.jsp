<%@ page session="true" %>
<html>
<head><title>Shopping Page 1</title></head>
<body>
    <h2>Shopping Mall - Page 1</h2>
    <form method="post">
        <input type="checkbox" name="items" value="100"> Product A ($100) <br>
        <input type="checkbox" name="items" value="200"> Product B ($200) <br><br>
        <input type="submit" value="Show Total & Next">
    </form>

    <%
        double page1Total = 0;
        String[] items = request.getParameterValues("items");
        if (items != null) {
            for (String price : items) {
                page1Total += Double.parseDouble(price);
            }
            session.setAttribute("page1Total", page1Total);
        } else {
            page1Total = session.getAttribute("page1Total") != null ? (double) session.getAttribute("page1Total") : 0;
        }
    %>

    <h3>Page 1 Total: $<%= page1Total %></h3>

    <form action="Slip9b-2.jsp">
        <input type="submit" value="Go to Page 2">
    </form>
</body>
</html>