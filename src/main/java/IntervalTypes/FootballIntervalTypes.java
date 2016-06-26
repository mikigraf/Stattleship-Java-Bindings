package IntervalTypes;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum FootballIntervalTypes {
    CONFERENCECHAMPIONSHIPS ("conferencechampionships"),
    DIVISIONALPLAYOFFS ("divisionalplayoffs"),
    POSTPONED ("postponed"),
    PRESEASONHALLOFFAMEWEEK ("preseasonhalloffameweek"),
    PRESEASONWEEK ("preseasonweek"),
    PROBOWL ("probowl"),
    SUPERBOWL ("superbowl"),
    WEEK ("week"),
    WILDCARD ("wildcard");

    private final String value;

    private FootballIntervalTypes(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
