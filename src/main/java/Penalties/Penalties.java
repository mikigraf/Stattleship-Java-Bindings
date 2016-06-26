package Penalties;

import Feats.FeatsParameters.FeatsParameters;
import GameLogs.SportLeague;
import IntervalTypes.BaseballIntervalTypes;
import Parameters.Parameters;
import Utils.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Penalties implements Parameters<Penalties> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public Penalties(SportLeague league){
        endpoint = league.toString() + "penalties";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public Penalties(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public Penalties build(){
        currentRequest = endpoint;
        return this;
    }

    public Penalties perPage(int num){
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

    public Penalties pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public Penalties game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public Penalties player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public Penalties team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public Penalties interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public Penalties season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public Penalties on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public Penalties since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public Penalties level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public Penalties name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
