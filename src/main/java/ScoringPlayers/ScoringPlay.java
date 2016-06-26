package ScoringPlayers;

import Feats.FeatsParameters.FeatsParameters;
import GameLogs.SportLeague;
import Rosters.Roster;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class ScoringPlay implements ScoringPlays<ScoringPlay> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public ScoringPlay(SportLeague league){
        endpoint = league.toString() + "scoring_plays";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public ScoringPlay(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public ScoringPlay perPage(int num){
        currentRequest = currentRequest + "&" + FeatsParameters.per_page.name() + "=";
        if(num > 40){
            currentRequest += 40;
        }else if(num < 0){
            currentRequest += 1;
        }else{
            currentRequest += num;
        }
        return this;
    }

    public ScoringPlay pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }
}
