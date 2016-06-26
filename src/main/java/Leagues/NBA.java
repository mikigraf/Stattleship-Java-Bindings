package Leagues;

import Feats.BaseballFeats;
import Feats.BasketballFeats;
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
public class NBA extends League {
    private final static String nbaEndpoint = "basketball/nba/";
    private BasketballFeats feats;
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


    public NBA(String endpoint) {
        super(endpoint);
    }

    public NBA(){

    }
    public String getEndpoint(){
        return nbaEndpoint;
    }

    public String getFeast(){
        feats = new BasketballFeats();
        Connector con = new Connector();
        return con.get(feats.getCurrentRequest());
    }

    public BasketballFeats getBasketballFeats(){
        return feats = new BasketballFeats();
    }

    public GameLogs getGameLogs(){
        return gamelogs = new GameLogs(SportLeague.NBA);
    }

    public Games getGames(){
        return games = new Games(SportLeague.NBA);
    }

    public Injuries getInjuries(){
        return injuries = new Injuries(SportLeague.NBA);
    }

    public Penalties getPenalties(){
        return penalties = new Penalties(SportLeague.NBA);
    }

    public Players getPlayers(){
        return players = new Players(SportLeague.NBA);
    }

    public Roster getRoster(){
        return roster = new Roster(SportLeague.NBA);
    }

    public StatLeader getStatleaders(){
        return statleaders = new StatLeader(SportLeague.NBA);
    }

    public Stats getStats(){
        return stats = new Stats(SportLeague.NBA);
    }

    public TeamGameLogs getTeamgamelogs(){
        return teamgamelogs = new TeamGameLogs(SportLeague.NBA);
    }

    public TeamOutcomeStreaks getTeamoutcomestreak(){
        return teamoutcomestreak = new TeamOutcomeStreaks(SportLeague.NBA);
    }

    public Teams getTeams(){
        return teams = new Teams(SportLeague.NBA);
    }

    public TopStats getTopStats(){
        return topstats = new TopStats(SportLeague.NBA);
    }

    public TotalStats getTotalStats(){
        return totalstats = new TotalStats(SportLeague.NBA);
    }
}
