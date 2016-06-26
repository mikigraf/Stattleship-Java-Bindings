package Leagues;

import Feats.BaseballFeats;
import Feats.BasketballFeats;
import Utils.Connector;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class NBA extends League {
    private final static String nbaEndpoint = "basketball/nba/";
    private BasketballFeats feats;

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
}
