<%@ page import="domain.model.Player" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 11.01.2017
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil gracza</title>
</head>
<body>
<% Player player = (Player) session.getAttribute("player");
%>
<h1>Nick : <%=player.getNick()%></h1>
<h1>Data urodzenia : <%=player.getDateOfBirth()%></h1>
<h1>Kraj : <%=player.getCountry()%></h1>
<h1>Steam id : <%=player.getSteamId()%></h1>
<h1> Team: <%=player.getTeam()%></h1>
</body>
</html>
