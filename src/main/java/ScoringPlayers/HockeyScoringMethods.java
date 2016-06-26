package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum HockeyScoringMethods {
    goal("goal");

    private final String value;

    private HockeyScoringMethods(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
