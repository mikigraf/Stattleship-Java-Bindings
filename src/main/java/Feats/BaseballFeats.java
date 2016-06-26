package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.BaseballFeatsParameters;
import IntervalTypes.BaseballIntervalTypes;
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
public class BaseballFeats implements Feats{
    private final static String endpoint = "baseball/mlb/feats";
    private Map<BaseballFeatsParameters, String> parameters;
    private String currentRequest;

    public BaseballFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<BaseballFeatsParameters, String>();
    }

    public void flush(){
        parameters.clear();
    }

    public String build(){
        return currentRequest = endpoint;
    }

    public String perPage(int num){
        currentRequest = currentRequest + "&" + BaseballFeatsParameters.per_page.name() + "=";
        if(num > 40){
            currentRequest += 40;
        }else if(num < 0){
            currentRequest += 1;
        }else{
            currentRequest += num;
        }
        return currentRequest;
    }

    public void pageOfResults(int pages){
        parameters.put(BaseballFeatsParameters.page,String.valueOf(pages));
    }

    public void game_id(String gameId){
        parameters.put(BaseballFeatsParameters.game_id,gameId);
    }

    public void player_id(String playerId){
        parameters.put(BaseballFeatsParameters.player_id,playerId);
    }

    public void team_id(String team_id){
        parameters.put(BaseballFeatsParameters.team_id,team_id);
    }

    public void interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(BaseballFeatsParameters.interval_type,intervalType.name());
    }

    public void season_id(String seasonId){
        parameters.put(BaseballFeatsParameters.season_id,seasonId);
    }

    public void on(String date){
        parameters.put(BaseballFeatsParameters.on,date);
    }

    public void since(String date){
        parameters.put(BaseballFeatsParameters.since,date);
    }

    public void level(int level){
        parameters.put(BaseballFeatsParameters.level,String.valueOf(level));
    }

    public void name(String name){
        parameters.put(BaseballFeatsParameters.name,name);
    }

    public String getCurrentRequest() {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(Map.Entry<BaseballFeatsParameters,String> entry : parameters.entrySet()){
            builder.addParameter(entry.getKey().name(),entry.getValue());
        }
        try {
            URL url = builder.build().toURL();
            return url.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
