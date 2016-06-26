package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.BaseballFeatsParameters;
import Feats.FeatsParameters.FootballFeatsParameters;
import Feats.FeatsParameters.HockeyParameters;
import IntervalTypes.FootballIntervalTypes;
import IntervalTypes.HockeyIntervalTypes;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class HockeyFeats implements Feats {
    private final static String endpoint = "hockey/nhl/feats";
    private Map<HockeyParameters, String> parameters;
    private String currentRequest;

    public HockeyFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<HockeyParameters, String>();
    }

    public void flush(){
        parameters.clear();
    }

    public String build(){
        return currentRequest = endpoint;
    }

    public String perPage(int num){
        currentRequest = currentRequest + "&" + HockeyParameters.per_page.name() + "=";
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
        parameters.put(HockeyParameters.page,String.valueOf(pages));
    }

    public void game_id(String gameId){
        parameters.put(HockeyParameters.game_id,gameId);
    }

    public void player_id(String playerId){
        parameters.put(HockeyParameters.player_id,playerId);
    }

    public void team_id(String team_id){
        parameters.put(HockeyParameters.team_id,team_id);
    }

    public void interval_tyoe(HockeyIntervalTypes intervalType){
        parameters.put(HockeyParameters.interval_type,intervalType.name());
    }

    public void season_id(String seasonId){
        parameters.put(HockeyParameters.season_id,seasonId);
    }

    public void on(String date){
        parameters.put(HockeyParameters.on,date);
    }

    public void since(String date){
        parameters.put(HockeyParameters.since,date);
    }

    public void level(int level){
        parameters.put(HockeyParameters.level,String.valueOf(level));
    }

    public void name(String name){
        parameters.put(HockeyParameters.name,name);
    }

    public String getCurrentRequest() {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(Map.Entry<HockeyParameters,String> entry : parameters.entrySet()){
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
