package IntervalTypes;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum BasketballIntervalTypes {
    ALLSTAR ("allstar"),
    CONFERENCEQUARTERFINALS ("conferencequarterfinals"),
    CONFERENCESEMIFINALS ("conferencesemifinals"),
    CONFERENCEFINALS ("conferencefinals"),
    NBACHAMPIONSHIP ("nbachampionship"),
    POSTPONED ("postponed"),
    PRESEASON ("preseason"),
    REGULARSEASON ("regularseason"),
    RISINGSTARSCHALLENGE ("risingstarschallenge");

    private final String value;

    private BasketballIntervalTypes(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
