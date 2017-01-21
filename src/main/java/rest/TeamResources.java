package rest;

import domain.model.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author L on 21.01.2017.
 */
@Path("/teams")
@Stateless
public class TeamResources {

    @PersistenceContext
    EntityManager entityManager;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Team> getAll() {
        return entityManager.createNamedQuery("team.all", Team.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Team team) {
        entityManager.persist(team);
        return Response.ok(team.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Team team) {
        Team result = entityManager.createNamedQuery("team.id", Team.class)
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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Team result = entityManager.createNamedQuery("team.id", Team.class)
                .setParameter("teamId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Team result = entityManager.createNamedQuery("team.id", Team.class)
                .setParameter("teamId", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }

}
