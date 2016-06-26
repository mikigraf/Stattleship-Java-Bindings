package Leagues;

import Feats.BaseballFeats;
import Feats.HockeyFeats;
import Utils.Connector;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class NHL extends League {
    private final static String nhlEndpoint = "hockey/nhl/";
    private HockeyFeats feats;

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
}
