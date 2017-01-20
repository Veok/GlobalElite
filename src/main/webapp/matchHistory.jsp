<%@ page import="domain.model.MatchHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="web.SessionKey" %>
<%@ page import="java.util.ArrayList" %><%---
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
<% ArrayList<MatchHistory> matchHistoryList = (ArrayList<MatchHistory>)session.getAttribute(SessionKey.histories);
%>
<%
    if(matchHistoryList== null){

    response.getWriter().write("Brak historii");
    }else{
    for(MatchHistory matchHistory : matchHistoryList){%>
<ol>
    <li><%=matchHistory.getTeam1().getName()%> <%=matchHistory.getScoreOfTeam1()%> <%=matchHistory.getScoreOfTeam2()%>
    <%=matchHistory.getTeam2().getName()%>  <%=matchHistory.getTimeOfMatch()%></li>
    <% }}%>


</ol>
</form>
</body>
<a href="addMatch.html">Dodaj nowy mecz</a>
</html>
