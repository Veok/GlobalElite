<%@ page import="domain.model.Team" %>
<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 10.01.2017
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
Czy poniższe dane się zgadzają?
<br>
<form action="TeamDbServlet" method="get">
    <% Team team = (Team) session.getAttribute("team");
    %>
    <h1>Nazwa drużyny : <%=team.getName()%>
    </h1>
    <h1>Reprezentowany kraj: <%=team.getCountry()%>
    </h1>

    <input type="submit" value="Potwierdź">
</form>
<form action="signUp.html">
    <input type="submit" value="Wróc">
</form>
</body>
</html>