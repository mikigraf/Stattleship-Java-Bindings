package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum ScoringParameters {
    scoring_method("scoring_method"),
    scoring_type("scoring_type");

    private final String value;

    private ScoringParameters(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
