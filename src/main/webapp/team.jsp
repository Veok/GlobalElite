<%@ page import="domain.model.Team" %>
<%@ page import="domain.model.TeamStatistics" %>
<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 16.01.2017
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twoja drużyna</title>
</head>
<body>
<%Team team = (Team) session.getAttribute("team");
    TeamStatistics teamStatistics = (TeamStatistics) session.getAttribute("teamStats");
team.setTeamStatistics(teamStatistics);%>
<h1>Nazwa drużyny: <%=team.getName()%></h1>
<br>
<h1>Reprezentowany kraj: <%=team.getCountry()%></h1>
<br>
<h1>Statystyki</h1>
<table >
    <tbody>
    <tr>
        <td>Wygrane: <%=team.getTeamStatistics().getWins()%> </td>
        <td>Przegrane: <%=team.getTeamStatistics().getLooses()%> </td>
        <td>Remisy:  <%=team.getTeamStatistics().getDraws()%></td>
        <td>Punkty: <%=team.getTeamStatistics().getPoints()%></td>
    </tr>
    </tbody>
</table>

</body>
</html>
