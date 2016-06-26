package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum FootballScoringMethods {
    scoring_play("scoring-play");

    private final String value;

    private FootballScoringMethods(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
