package Leagues;

import Feats.BaseballFeats;
import Feats.FootballFeasts;
import Utils.Connector;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class NFL extends League {
    private final static String nflEndpoint = "football/nfl/";
    private FootballFeasts feats;

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
}
