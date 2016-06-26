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
public class BaseballFeats implements Feats<BaseballFeats>{
    private final static String endpoint = "baseball/mlb/feats";
    private Map<BaseballFeatsParameters, String> parameters;
    private String currentRequest;

    public BaseballFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<BaseballFeatsParameters, String>();
    }

    public BaseballFeats(Map<BaseballFeatsParameters,String> parameters){
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
        currentRequest = currentRequest + "&" + BaseballFeatsParameters.per_page.name() + "=";
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
        parameters.put(BaseballFeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public BaseballFeats game_id(String gameId){
        parameters.put(BaseballFeatsParameters.game_id,gameId);
        return this;
    }

    public BaseballFeats player_id(String playerId){
        parameters.put(BaseballFeatsParameters.player_id,playerId);
        return this;
    }

    public BaseballFeats team_id(String team_id){
        parameters.put(BaseballFeatsParameters.team_id,team_id);
        return this;
    }

    public BaseballFeats interval_tyoe(BaseballIntervalTypes intervalType){
        parameters.put(BaseballFeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public BaseballFeats season_id(String seasonId){
        parameters.put(BaseballFeatsParameters.season_id,seasonId);
        return this;
    }

    public BaseballFeats on(String date){
        parameters.put(BaseballFeatsParameters.on,date);
        return this;
    }

    public BaseballFeats since(String date){
        parameters.put(BaseballFeatsParameters.since,date);
        return this;
    }

    public BaseballFeats level(int level){
        parameters.put(BaseballFeatsParameters.level,String.valueOf(level));
        return this;
    }

    public BaseballFeats name(String name){
        parameters.put(BaseballFeatsParameters.name,name);
        return this;
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
