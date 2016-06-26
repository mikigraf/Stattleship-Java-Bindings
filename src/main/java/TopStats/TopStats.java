package TopStats;

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
public class TopStats implements Parameters<TopStats> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public TopStats(SportLeague league){
        endpoint = league.toString() + "top_stats";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public TopStats(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public TopStats build(){
        currentRequest = endpoint;
        return this;
    }

    public TopStats perPage(int num){
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

    public TopStats pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public TopStats game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public TopStats player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public TopStats team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public TopStats interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public TopStats season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public TopStats on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public TopStats since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public TopStats level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public TopStats name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
