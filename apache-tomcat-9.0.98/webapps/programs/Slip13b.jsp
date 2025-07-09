<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>College Details</title>
    <style>
        table {
            /* border-collapse: collapse;
            width: 60%; */
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        /* th {
            background-color: #f2f2f2;
        } */
    </style>
</head>
<body>
    <h2 style="text-align:center;">College Details</h2>
    <table>
        <tr>
            <th>College ID</th>
            <th>College Name</th>
            <th>Address</th>
        </tr>
        <%
            // Sample static data - can be replaced with DB later
            String[][] colleges = {
                {"C101", "ABC College", "Mumbai"},
                {"C102", "XYZ Institute", "Delhi"},
                {"C103", "LMN University", "Chennai"},
                {"C104", "PQR College", "Bangalore"}
            };

            for (int i = 0; i < colleges.length; i++) {
        %>
        <tr>
            <td><%= colleges[i][0] %></td>
            <td><%= colleges[i][1] %></td>
            <td><%= colleges[i][2] %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
