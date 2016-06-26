package Rosters;

/**
 * Created by Mikolaj Wawrzyniak
 */
public interface Rosters<T> {
    /**
     * Items per page with maximum of 40, default 20.
     * @param num
     */
    public T perPage(int num);

    public T pageOfResults(int pages);

    /**
     * Player slug such as mlb-david-ortiz for David Ortiz
     * @param playerId
     */
    public T player_id(String playerId);

    /**
     * Team slug such as mlb-kc for the Kansas City Royals
     * @param team_id
     */
    public T team_id(String team_id);

}
