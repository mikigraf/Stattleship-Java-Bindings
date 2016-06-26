package GameLogs;

import Feats.FeatsParameters.FeatsParameters;
import IntervalTypes.BaseballIntervalTypes;
import Utils.Builder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class GameLogs {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public GameLogs(SportLeague league){
        endpoint = league.toString() + "game_logs";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public GameLogs(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public GameLogs build(){
        currentRequest = endpoint;
        return this;
    }

    public GameLogs perPage(int num){
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

    public GameLogs pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public GameLogs game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public GameLogs player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public GameLogs team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public GameLogs interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public GameLogs season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public GameLogs on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public GameLogs since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public GameLogs level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public GameLogs name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
