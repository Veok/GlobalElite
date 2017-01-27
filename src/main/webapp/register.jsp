<%@ page import="domain.model.Team" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 13.01.2017
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>    <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
    <link rel="stylesheet" type="text/css" href="../table.css">
    <title>Stwórz drużynę</title>
</head>
<body>
<form action="TeamDbServlet" method="get">

    <% Team team = (Team) session.getAttribute("team");
    %>

    <h1>Nazwa: <%= team.getName()%>
    </h1>
    <br>
    <h1>Kraj: <%= team.getCountry()%>
    </h1>
    <input type="submit" value="Potwierdź">
</form>
<form action="register.html">
    <input type="submit" value="Wróc">
</form>
</body>
</html>
