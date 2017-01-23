<%@ page import="domain.model.MatchHistory" %>
<%@ page import="hdao.MatchHistoryService" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%---
Created by IntelliJ IDEA.
  User: L
  Date: 20.01.2017
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Historia meczy</title>
    <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
    <link rel="stylesheet" type="text/css" href="../table.css">
</head>
<body>
<div class="table-title">
    <h3>Tabela wyników:</h3>
</div>
<table class="table-fill">

    <thead>
    <tr>
        <th class="text-left">Team1</th>
        <th class="text-left">Wynik1</th>
        <th class="text-left">Wynik2</th>
        <th class="text-left">Team2</th>
        <th class="text-left">Mapa</th>
        <th class="text-left">Czas gry</th>
    </tr>
    </thead>
    <tbody class="table-hover">
    <form action="MatchHistoryDbServlet" method="get">
            <%

        List<MatchHistory> list = MatchHistoryService.getListOfHistory();

        if (list.isEmpty()) {

            response.getWriter().write("Brak historii");
        } else {
            for (MatchHistory matchHistory : list) {
    %>

        <tr>
            <td>
                <%=matchHistory.getTeam1().getName()%>
            </td>
            <td><%=matchHistory.getScoreOfTeam1()%>
            </td>
            <td>
                <%=matchHistory.getScoreOfTeam2()%>
            </td>
            <td>
                <%=matchHistory.getTeam2().getName()%>
            </td>
            <td>
                <%=matchHistory.getGameMap().getNameOfMap()%>
            </td>
            <td>
                <%=matchHistory.getTimeOfMatch()%>
            </td>
        </tr>


            <%
            }
        }
    %>
    </tbody>
</table>

</form>
<br>
<a href="addMatch.html">Dodaj nowy mecz</a>
</body>

</html>
