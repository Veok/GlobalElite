package rest;

import domain.model.Team;
import domain.model.TeamStatistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 21.01.2017.
 */
@XmlRootElement
@Path("/teams")
@Stateless
public class TeamResources {

    @PersistenceContext
    private
    EntityManager entityManager;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Team> teams = new ArrayList<>();
        teams.add((Team) entityManager
                .createNamedQuery("team.all", Team.class)
                .getResultList());
        return Response.ok(teams).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Team team) {
        TeamStatistics teamStatistics = new TeamStatistics();
        teamStatistics.setWins(0);
        teamStatistics.setDraws(0);
        teamStatistics.setLooses(0);
        team.setTeamStatistics(teamStatistics);
        entityManager.persist(teamStatistics);
        entityManager.persist(team);
        return Response.ok(team.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Team team) {
        Team result = entityManager
                .createNamedQuery("team.id", Team.class)
                .setParameter("teamId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        team.setName(team.getName());
        team.setCountry(team.getCountry());
        team.setTeamStatistics(team.getTeamStatistics());
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Team result = entityManager
                .createNamedQuery("team.id", Team.class)
                .setParameter("teamId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name){
        Team result = entityManager
                .createNamedQuery("team.name", Team.class)
                .setParameter("teamName", name)
                .getSingleResult();
        if(result==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(result).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Team result = entityManager
                .createNamedQuery("team.id", Team.class)
                .setParameter("teamId", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }

}
