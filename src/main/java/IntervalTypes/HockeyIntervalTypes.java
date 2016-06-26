package IntervalTypes;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum HockeyIntervalTypes {
    ALLSTAR ("allstar"),
    POSTPONED ("postponed"),
    PRESEASON ("preseason"),
    REGULARSEASON ("regularseason"),
    CONFERENCEQUARTERFINALS ("conferencequarterfinals"),
    CONFERENCESEMIFINALS ("conferencesemifinals"),
    CONFERENCEFINALS ("conferencefinals"),
    STANLEYCUPFINALS ("stanleycupfinals");

    private final String value;

    private HockeyIntervalTypes(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
