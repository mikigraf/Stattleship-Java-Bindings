package StatLeaders;

/**
 * Created by Mikolaj Wawrzyniak
 */
public interface StatLeaders<T> {
    /**
     * Items per page with maximum of 40, default 20.
     * @param num
     */
    public T perPage(int num);

    public T pageOfResults(int pages);

    /**
     * Season slug such as mlb-2016
     * @param seasonId
     */
    public T season_id(String seasonId);


}
