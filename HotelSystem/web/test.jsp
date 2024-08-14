<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered table-hover">
        <%
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
        %>
        <tr>
            <td>BB</td>
        </tr>
        <%} else {%>
        <tr>
            <td>AA</td>
        </tr>
        <% }
        }%>
    </table>
</div>
</body>
</html>
