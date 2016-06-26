package GameLogs;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum SportLeague {
    NHL("hockey/nhl/"),
    NBA("basketball/nba/"),
    NFL("football/nfl/"),
    MLB("baseball/mlb/");

    private final String value;

    private SportLeague(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
