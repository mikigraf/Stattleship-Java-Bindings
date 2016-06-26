package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.FootballFeatsParameters;
import IntervalTypes.FootballIntervalTypes;
import Parameters.Parameters;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class FootballFeasts implements Parameters<FootballFeasts> {
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

    public FootballFeasts build(){
        currentRequest = endpoint;
        return this;
    }

    public FootballFeasts perPage(int num){
        currentRequest = currentRequest + "&" + FootballFeatsParameters.per_page.name() + "=";
        if(num > 40){
            currentRequest += 40;
        }else if(num < 0){
            currentRequest += 1;
        }else{
            currentRequest += num;
        }
        return this;
    }

    public FootballFeasts pageOfResults(int pages){
        parameters.put(FootballFeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public FootballFeasts game_id(String gameId){
        parameters.put(FootballFeatsParameters.game_id,gameId);
        return this;
    }

    public FootballFeasts player_id(String playerId){
        parameters.put(FootballFeatsParameters.player_id,playerId);
        return this;
    }

    public FootballFeasts team_id(String team_id){
        parameters.put(FootballFeatsParameters.team_id,team_id);
        return this;
    }

    public void interval_type(FootballIntervalTypes intervalType){
        parameters.put(FootballFeatsParameters.interval_type,intervalType.name());
    }

    public FootballFeasts season_id(String seasonId){
        parameters.put(FootballFeatsParameters.season_id,seasonId);
        return this;
    }

    public FootballFeasts on(String date){
        parameters.put(FootballFeatsParameters.on,date);
        return this;
    }

    public FootballFeasts since(String date){
        parameters.put(FootballFeatsParameters.since,date);
        return this;
    }

    public FootballFeasts level(int level){
        parameters.put(FootballFeatsParameters.level,String.valueOf(level));
        return this;
    }

    public FootballFeasts name(String name){
        parameters.put(FootballFeatsParameters.name,name);
        return this;
    }

    public FootballFeasts week(int week){
        parameters.put(FootballFeatsParameters.week,String.valueOf(week));
        return this;
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
