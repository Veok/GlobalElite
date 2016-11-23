package dao.repositories;

import domain.model.GeneralPlayerStats;

import java.util.List;

/**
 * @author L on 18.11.2016.
 */
public interface IGeneralPlayerStatsRepository extends IRepository<GeneralPlayerStats> {

    public List<GeneralPlayerStats> kills(int kills);

    public List<GeneralPlayerStats> deaths(int deaths);

    public List<GeneralPlayerStats> ratio(double ratio);
}
