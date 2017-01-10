<%@ page import="domain.model.Player" %><%--
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
<% Player player = (Player) session.getAttribute("player");
%>
<h1>Nick : <%=player.getNick()%></h1>
<h1>Data urodzenia : <%=player.getDateOfBirth()%></h1>
<h1>Kraj : <%=player.getCountry()%></h1>
<h1>Steam id : <%=player.getSteamId()%></h1>
<form action="DbServlet" method="get">
    <input type="submit" value="Potwierdź">
</form>
<form action="signUp.html">
    <input type="submit" value="Wróć">
</form>
</body>
</html>
