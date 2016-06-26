package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum HockeyScoringType {
    ev("ev"),
    pp("pp"),
    sh("sh");

    private final String value;

    private HockeyScoringType(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
