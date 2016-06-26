package TeamOutcomeStreaks;

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
public class TeamOutcomeStreaks implements Parameters<TeamOutcomeStreaks> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public TeamOutcomeStreaks(SportLeague league){
        endpoint = league.toString() + "team_outcome_streaks";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public TeamOutcomeStreaks(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public TeamOutcomeStreaks build(){
        currentRequest = endpoint;
        return this;
    }

    public TeamOutcomeStreaks perPage(int num){
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

    public TeamOutcomeStreaks pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public TeamOutcomeStreaks game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public TeamOutcomeStreaks player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public TeamOutcomeStreaks team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public TeamOutcomeStreaks interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public TeamOutcomeStreaks season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public TeamOutcomeStreaks on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public TeamOutcomeStreaks since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public TeamOutcomeStreaks level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public TeamOutcomeStreaks name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
