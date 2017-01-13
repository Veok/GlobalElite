<%@ page import="domain.model.Player" %>
<%@ page import="domain.model.PlayerStatistics" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 12.01.2017
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil gracza</title>
</head>
<body>
<%
    PlayerStatistics playerStatistics = (PlayerStatistics) session.getAttribute("playerStats");
    Player player = (Player) session.getAttribute("player");
    player.setPlayerStatistics(playerStatistics);

%>
<h1>Nick : <%=player.getNick()%></h1>
<h1>Data urodzenia : <%=player.getDateOfBirth()%></h1>
<h1>Kraj : <%=player.getCountry()%></h1>
<h1>Steam id : <%=player.getSteamId()%></h1>
<br>
<table >
    <tbody>
    <tr>
        <td>Zabici: <%=player.getPlayerStatistics().getKills()%> </td>
        <td>Zgony: <%=player.getPlayerStatistics().getDeaths()%> </td>
        <td>K/D L <%=player.getPlayerStatistics().getRatio()%> </td>
    </tr>
    </tbody>
</table>
<a href="joinTeam.html">Dołącz do drużyny</a>
<a href="createTeam.html">Stwórz swoją własną drużynę</a>
</body>
</html>
