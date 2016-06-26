package Feats.FeatsParameters;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum BaseballFeatsParameters {
    per_page("per_page"),
    page("page"),
    game_id("game_id"),
    player_id("player_id"),
    team_id("team_id"),
    interval_type("interval_type"),
    season_id("season_id"),
    on("on"),
    since("since"),
    level("level"),
    name("name");

    private final String value;

    private BaseballFeatsParameters(String s) {
        value = s;
    }
}
