package ScoringPlayers;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum FootballScoringType {
    touchdown("touchdown"),
    safety("safety"),
    failed_conversion("failed-conversion-return"),
    fieldgoal("field-goal");

    private final String value;

    private FootballScoringType(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
