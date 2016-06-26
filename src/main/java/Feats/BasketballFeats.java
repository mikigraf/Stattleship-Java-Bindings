package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.BaseballFeatsParameters;
import Feats.FeatsParameters.BasketballFeatsParameters;
import IntervalTypes.BaseballIntervalTypes;
import IntervalTypes.BasketballIntervalTypes;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class BasketballFeats implements Feats{
    private final static String endpoint = "basketball/nba/feats";
    private Map<BasketballFeatsParameters, String> parameters;
    private String currentRequest;

    public BasketballFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<BasketballFeatsParameters, String>();
    }

    public void flush(){
        parameters.clear();
    }

    public String build(){
        return currentRequest = endpoint;
    }

    public String perPage(int num){
        currentRequest = currentRequest + "&" + BasketballFeatsParameters.per_page.name() + "=";
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
        parameters.put(BasketballFeatsParameters.page,String.valueOf(pages));
    }

    public void game_id(String gameId){
        parameters.put(BasketballFeatsParameters.game_id,gameId);
    }

    public void player_id(String playerId){
        parameters.put(BasketballFeatsParameters.player_id,playerId);
    }

    public void team_id(String team_id){
        parameters.put(BasketballFeatsParameters.team_id,team_id);
    }

    public void interval_tyoe(BasketballIntervalTypes intervalType){
        parameters.put(BasketballFeatsParameters.interval_type,intervalType.name());
    }

    public void season_id(String seasonId){
        parameters.put(BasketballFeatsParameters.season_id,seasonId);
    }

    public void on(String date){
        parameters.put(BasketballFeatsParameters.on,date);
    }

    public void since(String date){
        parameters.put(BasketballFeatsParameters.since,date);
    }

    public void level(int level){
        parameters.put(BasketballFeatsParameters.level,String.valueOf(level));
    }

    public void name(String name){
        parameters.put(BasketballFeatsParameters.name,name);
    }

    public String getCurrentRequest() {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(Map.Entry<BasketballFeatsParameters,String> entry : parameters.entrySet()){
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
