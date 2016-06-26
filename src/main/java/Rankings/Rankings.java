package Rankings;

/**
 * Created by Mikolaj Wawrzyniak
 */
public interface Rankings<T> {
    /**
     * Items per page with maximum of 40, default 20.
     * @param num
     */
    public T perPage(int num);

    public T pageOfResults(int pages);

    public T ranking(String ranking);

    /**
     * Friendly date such as today or tomorrow; or a timestamp; or a date such as 2016-05-22
     * @param date
     */
    public T on(String date);

    public T since(String date);
}
