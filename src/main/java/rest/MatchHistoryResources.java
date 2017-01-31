package rest;

import domain.model.MatchHistory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 23.01.2017.
 */
@XmlRootElement
@Path("/history")
@Stateless
public class MatchHistoryResources {

    @PersistenceContext
    private EntityManager entityManager;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<MatchHistory> matchHistories = new ArrayList<>();
        for (MatchHistory m : entityManager
                .createNamedQuery("matchHistory.all", MatchHistory.class)
                .getResultList())
            matchHistories.add(m);


        return Response.ok(new GenericEntity<List<MatchHistory>>(matchHistories) {
        }).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(MatchHistory matchHistory) {

        entityManager.persist(matchHistory);
        matchHistory.score();
        return Response.ok(matchHistory.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, MatchHistory matchHistory) {
        MatchHistory result = entityManager.createNamedQuery("matchHistory.id", MatchHistory.class)
                .setParameter("matchHistoryId", id)
                .getSingleResult();
        if (result == null) {
            return Response.ok().build();
        }
        matchHistory.setTeam1(matchHistory.getTeam1());
        matchHistory.setTeam2(matchHistory.getTeam2());
        matchHistory.setGameMap(matchHistory.getGameMap());
        matchHistory.setScoreOfTeam1(matchHistory.getScoreOfTeam1());
        matchHistory.setScoreOfTeam2(matchHistory.getScoreOfTeam2());
        matchHistory.score();
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        MatchHistory result = entityManager
                .createNamedQuery("matchHistory.id", MatchHistory.class)
                .setParameter("matchHistoryId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        MatchHistory result = entityManager
                .createNamedQuery("matchHistory.id", MatchHistory.class)
                .setParameter("matchHistoryId", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }

}
