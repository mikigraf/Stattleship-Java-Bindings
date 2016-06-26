package IntervalTypes;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum BaseballIntervalTypes {
    ALLSTAR ("allstar"),
    DIVISIONALPLAYOFF ("divisionalplayoff"),
    LEAGUECHAMPIONSHIP ("leaguechampionship"),
    POSTPONED ("postponed"),
    PRESEASON ("preseason"),
    REGULARSEASON ("regularseason"),
    WILDCARDSHOWDOWN ("wildcardshowdown"),
    WORLDSERIES ("worldseries");

    private final String value;

    private BaseballIntervalTypes(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
