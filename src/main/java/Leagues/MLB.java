package Leagues;

import Feats.BaseballFeats;
import GameLogs.GameLogs;
import Utils.Connector;
import GameLogs.SportLeague;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class MLB extends League {
    private final static String mlbEndpoint = "baseball/mlb/";
    private BaseballFeats feats;
    private GameLogs gamelogs;


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
}
