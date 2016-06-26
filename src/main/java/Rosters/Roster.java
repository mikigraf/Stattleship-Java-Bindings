package Rosters;

import Feats.FeatsParameters.FeatsParameters;
import GameLogs.SportLeague;
import Utils.Builder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Roster implements Rosters<Roster>{
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public Roster(SportLeague league){
        endpoint = league.toString() + "roster";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public Roster(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public Roster build(){
        currentRequest = endpoint;
        return this;
    }

    public Roster perPage(int num){
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

    public Roster pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public Roster game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public Roster player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public Roster team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }
    
    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
