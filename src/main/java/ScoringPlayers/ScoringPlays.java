package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public interface ScoringPlays<T> {
    /**
     * Items per page with maximum of 40, default 20.
     * @param num
     */
    public T perPage(int num);

    public T pageOfResults(int pages);
}
