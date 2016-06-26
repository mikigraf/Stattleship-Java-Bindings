package Rankings;

/**
 * Created by Mikolaj Wawrzyniak
 */
public enum BasketballRankings {
    basketball_daily_player_assists_ranking ("basketball_daily_player_assists_ranking"),
    basketball_daily_player_minutes_played_ranking ("basketball_daily_player_minutes_played_ranking"),
    basketball_daily_player_performance_ranking ("basketball_daily_player_performance_ranking"),
    basketball_daily_player_rebounds_total_ranking ("basketball_daily_player_rebounds_total_ranking"),
    basketball_daily_player_steals_ranking ("basketball_daily_player_steals_ranking"),
    basketball_daily_veteran_player_performance_ranking ("basketball_daily_veteran_player_performance_ranking"),
    basketball_daily_young_player_performance_ranking ("basketball_daily_young_player_performance_ranking");

    private final String value;

    private BasketballRankings(String s) {
        value = s;
    }

    public String toString() {
        return this.value;
    }

}
