<%@ page import="domain.model.MatchHistory" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 16.01.2017
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj mecz</title>
</head>
<body>
<form action="MatchHistoryDbServlet" method="get">

    <%
        MatchHistory matchHistory = (MatchHistory) session.getAttribute("matchHistory"); %>

    Wygrany: <%=matchHistory.getTeam1().getName()%>
    <br>
    Przegrany: <%=matchHistory.getTeam2().getName()%>
    <br>
    Wynik wygranego: <%=matchHistory.getScoreOfTeam1()%>
    <br>
    Wynik przegranego: <%=matchHistory.getScoreOfTeam2()%>
    <br>
    Mapa: <%=matchHistory.getGameMap().getNameOfMap()%>
    <br>
    Czas: <%=matchHistory.getTimeOfMatch()%>
    <input type="submit" value="Potwierdź">
</form>
<form action="matchHistory.jsp">
    <input type="submit" value="Wróc">
</form>
</body>
</html>
