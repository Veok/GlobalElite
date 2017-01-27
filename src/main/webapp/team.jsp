<%@ page import="domain.model.Team" %>
<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 16.01.2017
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>    <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
    <link rel="stylesheet" type="text/css" href="../table.css">
    <title>Twoja drużyna</title>
</head>
<body>
<%
    Team team = (Team) session.getAttribute("login");
%>
<div id="content"></div>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">

    var content = $('#content');
    var nameOfTeam = <%=team.getName()%>;

        $.ajax({
            url: "rest/teams/name/"+nameOfTeam,
            dataType: "json",
            method: 'GET',
            success: function showInfo(text) {
                alert(text);
            }

        })



</script>
<h1>Nazwa drużyny: <%=team.getName()%>
</h1>
<br>
<h1>Reprezentowany kraj: <%=team.getCountry()%>
</h1>
<br>
<h1>Statystyki</h1>
<table>
    <tbody>
    <tr>
        <td>Wygrane: <%=team.getTeamStatistics().getWins()%>
        </td>
        <td>Przegrane: <%=team.getTeamStatistics().getLooses()%>
        </td>
        <td>Remisy:  <%=team.getTeamStatistics().getDraws()%>
        </td>
        <td>Punkty: <%=team.getTeamStatistics().getPoints()%>
        </td>
    </tr>

    </tbody>
</table>
<a href="matchHistory.jsp">Tablica wyników</a>
</body>
</html>
