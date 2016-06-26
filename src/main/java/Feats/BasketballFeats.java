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
public class BasketballFeats implements Feats<BasketballFeats>{
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

    public BasketballFeats build(){
        currentRequest = endpoint;
        return this;
    }

    public BasketballFeats perPage(int num){
        currentRequest = currentRequest + "&" + BasketballFeatsParameters.per_page.name() + "=";
        if(num > 40){
            currentRequest += 40;
        }else if(num < 0){
            currentRequest += 1;
        }else{
            currentRequest += num;
        }
        return this;
    }

    public BasketballFeats pageOfResults(int pages){
        parameters.put(BasketballFeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public BasketballFeats game_id(String gameId){
        parameters.put(BasketballFeatsParameters.game_id,gameId);
        return this;
    }

    public BasketballFeats player_id(String playerId){
        parameters.put(BasketballFeatsParameters.player_id,playerId);
        return this;
    }

    public BasketballFeats team_id(String team_id){
        parameters.put(BasketballFeatsParameters.team_id,team_id);
        return this;
    }

    public BasketballFeats interval_tyoe(BasketballIntervalTypes intervalType){
        parameters.put(BasketballFeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public BasketballFeats season_id(String seasonId){
        parameters.put(BasketballFeatsParameters.season_id,seasonId);
        return this;
    }

    public BasketballFeats on(String date){
        parameters.put(BasketballFeatsParameters.on,date);
        return this;
    }

    public BasketballFeats since(String date){
        parameters.put(BasketballFeatsParameters.since,date);
        return this;
    }

    public BasketballFeats level(int level){
        parameters.put(BasketballFeatsParameters.level,String.valueOf(level));
        return this;
    }

    public BasketballFeats name(String name){
        parameters.put(BasketballFeatsParameters.name,name);
        return this;
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
