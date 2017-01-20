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
</head>
<body>
<form action="MatchHistoryDbServlet" method="get">
    <%

        List<MatchHistory> list = MatchHistoryService.getListOfHistory();

        if (list.isEmpty()) {

            response.getWriter().write("Brak historii");
        } else {
            for (MatchHistory matchHistory : list) {
    %>
    <table>
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
                <%=matchHistory.getTeam2()%>
            </td>
            <td>
                <%=matchHistory.getGameMap()%>
            </td>
            <td>
                <%=matchHistory.getTimeOfMatch()%>
            </td>
        </tr>
    </table>

    <%
            }
        }
    %>


</form>
</body>
<a href="addMatch.html">Dodaj nowy mecz</a>
</html>
