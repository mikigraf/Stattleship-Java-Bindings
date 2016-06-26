package Stats;
import Feats.FeatsParameters.FeatsParameters;
import GameLogs.SportLeague;
import IntervalTypes.BaseballIntervalTypes;
import Parameters.Parameters;
import Stats.Stats;
import Utils.Builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Stats implements Parameters<Stats> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public Stats(SportLeague league){
        endpoint = league.toString() + "stats";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public Stats(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public Stats build(){
        currentRequest = endpoint;
        return this;
    }

    public Stats perPage(int num){
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

    public Stats pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public Stats game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public Stats player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public Stats team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public Stats interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public Stats season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public Stats on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public Stats since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public Stats level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public Stats name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
