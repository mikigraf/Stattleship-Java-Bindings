package Leagues;

import Feats.BaseballFeats;
import Feats.FootballFeasts;
import GameLogs.GameLogs;
import Games.Games;
import Injuries.Injuries;
import Penalties.Penalties;
import Players.Players;
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
public class NFL extends League {
    private final static String nflEndpoint = "football/nfl/";
    private FootballFeasts feats;
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


    public NFL(String endpoint) {
        super(endpoint);
    }

    public NFL(){

    }
    public String getEndpoint(){
        return nflEndpoint;
    }

    public FootballFeasts getFootballFeats(){
        return feats = new FootballFeasts();
    }

    public GameLogs getGameLogs(){
        return gamelogs = new GameLogs(SportLeague.NFL);
    }

    public Games getGames(){
        return games = new Games(SportLeague.NFL);
    }

    public Injuries getInjuries(){
        return injuries = new Injuries(SportLeague.NFL);
    }

    public Penalties getPenalties(){
        return penalties = new Penalties(SportLeague.NFL);
    }

    public Players getPlayers(){
        return players = new Players(SportLeague.NFL);
    }

    public Roster getRoster(){
        return roster = new Roster(SportLeague.NFL);
    }

    public StatLeader getStatleaders(){
        return statleaders = new StatLeader(SportLeague.NFL);
    }

    public Stats getStats(){
        return stats = new Stats(SportLeague.NFL);
    }

    public TeamGameLogs getTeamgamelogs(){
        return teamgamelogs = new TeamGameLogs(SportLeague.NFL);
    }

    public TeamOutcomeStreaks getTeamoutcomestreak(){
        return teamoutcomestreak = new TeamOutcomeStreaks(SportLeague.NFL);
    }

    public Teams getTeams(){
        return teams = new Teams(SportLeague.NFL);
    }

    public TopStats getTopStats(){
        return topstats = new TopStats(SportLeague.NFL);
    }

    public TotalStats getTotalStats(){
        return totalstats = new TotalStats(SportLeague.NFL);
    }
}
