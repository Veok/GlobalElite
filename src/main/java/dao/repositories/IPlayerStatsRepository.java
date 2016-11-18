package dao.repositories;

import domain.model.Player;
import domain.model.PlayerStats;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IPlayerStatsRepository extends IRepository<PlayerStats> {

    public List<PlayerStats> kills(int kills);
    public List<PlayerStats> deaths(int deaths );
    public List<PlayerStats> ratio(double ratio);
}
