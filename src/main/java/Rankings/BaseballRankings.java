package Rankings;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum BaseballRankings{
    baseball_daily_player_hitter_ranking ("baseball_daily_player_hitter_ranking"),
    baseball_daily_player_pitcher_ranking ("baseball_daily_player_pitcher_ranking"),
    baseball_daily_team_longest_game_ranking ("baseball_daily_team_longest_game_ranking"),
    baseball_season_team_longest_game_ranking ("baseball_season_team_longest_game_ranking");

    private final String value;

    private BaseballRankings(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }
}
