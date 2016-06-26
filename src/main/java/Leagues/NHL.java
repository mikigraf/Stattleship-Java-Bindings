package Leagues;

import Feats.BaseballFeats;
import Feats.HockeyFeats;
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
public class NHL extends League {
    private final static String nhlEndpoint = "hockey/nhl/";
    private HockeyFeats feats;
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


    public NHL(String endpoint) {
        super(endpoint);
    }

    public NHL(){

    }
    public String getEndpoint(){
        return nhlEndpoint;
    }

    public String getFeast(){
        feats = new HockeyFeats();
        Connector con = new Connector();
        return con.get(feats.getCurrentRequest());
    }

    public HockeyFeats getHockeyFeasts(){
        return feats = new HockeyFeats();
    }
    
    public GameLogs getGameLogs(){
        return gamelogs = new GameLogs(SportLeague.NHL);
    }

    public Games getGames(){
        return games = new Games(SportLeague.NHL);
    }

    public Injuries getInjuries(){
        return injuries = new Injuries(SportLeague.NHL);
    }

    public Penalties getPenalties(){
        return penalties = new Penalties(SportLeague.NHL);
    }

    public Players getPlayers(){
        return players = new Players(SportLeague.NHL);
    }

    public Roster getRoster(){
        return roster = new Roster(SportLeague.NHL);
    }

    public StatLeader getStatleaders(){
        return statleaders = new StatLeader(SportLeague.NHL);
    }

    public Stats getStats(){
        return stats = new Stats(SportLeague.NHL);
    }

    public TeamGameLogs getTeamgamelogs(){
        return teamgamelogs = new TeamGameLogs(SportLeague.NHL);
    }

    public TeamOutcomeStreaks getTeamoutcomestreak(){
        return teamoutcomestreak = new TeamOutcomeStreaks(SportLeague.NHL);
    }

    public Teams getTeams(){
        return teams = new Teams(SportLeague.NHL);
    }

    public TopStats getTopStats(){
        return topstats = new TopStats(SportLeague.NHL);
    }

    public TotalStats getTotalStats(){
        return totalstats = new TotalStats(SportLeague.NHL);
    }
}
