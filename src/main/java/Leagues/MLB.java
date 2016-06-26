package Leagues;

import Feats.BaseballFeats;
import Feats.FeatsParameters.BaseballFeatsParameters;
import Utils.Connector;

import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class MLB extends League {
    private final static String mlbEndpoint = "baseball/mlb/";
    private BaseballFeats feats;

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
}
