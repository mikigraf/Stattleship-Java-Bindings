package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.FeatsParameters;
import IntervalTypes.BaseballIntervalTypes;
import Parameters.Parameters;
import Utils.Builder;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 * using the official documentation
 * Remember — happy Feats specify valid subjects, like a player_id, team_id, or game_id!
 */
public class BaseballFeats implements Parameters<BaseballFeats> {
    private final static String endpoint = "baseball/mlb/feats";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public BaseballFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public BaseballFeats(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public BaseballFeats build(){
        currentRequest = endpoint;
        return this;
    }

    public BaseballFeats perPage(int num){
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

    public BaseballFeats pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public BaseballFeats game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public BaseballFeats player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public BaseballFeats team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public BaseballFeats interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public BaseballFeats season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public BaseballFeats on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public BaseballFeats since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public BaseballFeats level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public BaseballFeats name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
