package hdao.repositories;

import domain.model.MatchHistory;
import domain.model.Team;

import java.util.List;

/**
 * @author L on 23.01.2017.
 */
public interface IHMatchHistoryRepository extends IHRepository<MatchHistory> {

    List<MatchHistory> bestTeam();
    List<MatchHistory> worstTeam();
    List<MatchHistory> onMap(String name);
    void getById(int id);


}
