package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.BaseballFeatsParameters;
import Feats.FeatsParameters.FootballFeatsParameters;
import IntervalTypes.BaseballIntervalTypes;
import IntervalTypes.FootballIntervalTypes;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class FootballFeasts implements Feats {
    private final static String endpoint = "football/nfl/feats";
    private Map<FootballFeatsParameters, String> parameters;
    private String currentRequest;

    public FootballFeasts(){
        currentRequest = endpoint;
        parameters = new HashMap<FootballFeatsParameters, String>();
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
        parameters.put(FootballFeatsParameters.page,String.valueOf(pages));
    }

    public void game_id(String gameId){
        parameters.put(FootballFeatsParameters.game_id,gameId);
    }

    public void player_id(String playerId){
        parameters.put(FootballFeatsParameters.player_id,playerId);
    }

    public void team_id(String team_id){
        parameters.put(FootballFeatsParameters.team_id,team_id);
    }

    public void interval_tyoe(FootballIntervalTypes intervalType){
        parameters.put(FootballFeatsParameters.interval_type,intervalType.name());
    }

    public void season_id(String seasonId){
        parameters.put(FootballFeatsParameters.season_id,seasonId);
    }

    public void on(String date){
        parameters.put(FootballFeatsParameters.on,date);
    }

    public void since(String date){
        parameters.put(FootballFeatsParameters.since,date);
    }

    public void level(int level){
        parameters.put(FootballFeatsParameters.level,String.valueOf(level));
    }

    public void name(String name){
        parameters.put(FootballFeatsParameters.name,name);
    }

    public String getCurrentRequest() {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(Map.Entry<FootballFeatsParameters,String> entry : parameters.entrySet()){
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
