package Leagues;

import Feats.BaseballFeats;
import GameLogs.GameLogs;
import Games.Games;
import Injuries.Injuries;
import Penalties.Penalties;
import Players.Players;
import Rankings.BaseballRankings;
import Rankings.BasketballRankings;
import Rankings.Ranking;
import Rosters.Roster;
import StatLeaders.StatLeader;
import Stats.Stats;
import TeamGameLogs.TeamGameLogs;
import TeamOutcomeStreaks.TeamOutcomeStreaks;
import Teams.Teams;
import TopStats.TopStats;
import TotalStats.TotalStats;
import Utils.Connector;
import GameLogs.SportLeague;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class MLB extends League {
    private final static String mlbEndpoint = "baseball/mlb/";
    private BaseballFeats feats;
    private GameLogs gamelogs;
    private Games games;
    private Injuries injuries;
    private Penalties penalties;
    private Players players;
    private Roster roster;
    private StatLeader statleaders;
    private Stats stats;
    private TeamGameLogs teamgamelogs;
    private TeamOutcomeStreaks teamoutcomestreak;
    private Teams teams;
    private TopStats topstats;
    private TotalStats totalstats;

    public MLB(String endpoint) {
        super(endpoint);
    }

    public MLB(){

    }
    public String getEndpoint(){
        return mlbEndpoint;
    }

    public String getFeast(){
        feats = new BaseballFeats();
        Connector con = new Connector();
        return con.get(feats.getCurrentRequest());
    }

    public BaseballFeats getBaseballFeats(){
        return feats = new BaseballFeats();
    }

    public GameLogs getGameLogs(){
        return gamelogs = new GameLogs(SportLeague.MLB);
    }

    public Games getGames(){
        return games = new Games(SportLeague.MLB);
    }

    public Injuries getInjuries(){
        return injuries = new Injuries(SportLeague.MLB);
    }

    public Penalties getPenalties(){
        return penalties = new Penalties(SportLeague.MLB);
    }

    public Players getPlayers(){
        return players = new Players(SportLeague.MLB);
    }

    public Roster getRoster(){
        return roster = new Roster(SportLeague.MLB);
    }

    public StatLeader getStatleaders(){
        return statleaders = new StatLeader(SportLeague.MLB);
    }

    public Stats getStats(){
        return stats = new Stats(SportLeague.MLB);
    }

    public TeamGameLogs getTeamgamelogs(){
        return teamgamelogs = new TeamGameLogs(SportLeague.MLB);
    }

    public TeamOutcomeStreaks getTeamoutcomestreak(){
        return teamoutcomestreak = new TeamOutcomeStreaks(SportLeague.MLB);
    }

    public Teams getTeams(){
        return teams = new Teams(SportLeague.MLB);
    }

    public TopStats getTopStats(){
        return topstats = new TopStats(SportLeague.MLB);
    }

    public TotalStats getTotalStats(){
        return totalstats = new TotalStats(SportLeague.MLB);
    }
}
