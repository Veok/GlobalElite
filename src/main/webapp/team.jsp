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
<head>
    <link rel="stylesheet" type="text/css" href="../table.css">
    <title>Twoja drużyna</title>
</head>
<body>
<%
    Team team = (Team) session.getAttribute("login");
%>

<b> Nazwa drużyny: </b>
<div id="name"></div>
<b> Kraj: </b>
<div id="country"></div>

<table>
    <tbody>
    <tr>
        <td>Wygrane:
            <div id="wins"></div>
        </td>
        <td>Przegrane:
            <div id="looses"></div>
        </td>
        <td>Remisy:
            <div id="draws"></div>
        </td>

    </tr>

    </tbody>
</table>
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">


    var nameOfTeam = "<%=team.getName()%>";
    var currentTeam;

    findTeam();
    function findTeam() {
        console.log("findTeam");
        console.log(nameOfTeam);
        $.ajax({
            url: "http://localhost:8080/rest/teams/name/" + nameOfTeam,
            method: 'GET',
            success: function (data) {
                currentTeam = data;
                renderDetails(currentTeam);
            }

        });
    }
    function renderDetails(team) {
        $('#name').html(team.name);
        $('#country').html(team.country);
        $('#wins').html(team.teamStatistics.wins);
        $('#looses').html(team.teamStatistics.looses);
        $('#draws').html(team.teamStatistics.draws);

    }


</script>

<a href="matchHistory.jsp">Tablica wyników</a>

</body>
</html>
