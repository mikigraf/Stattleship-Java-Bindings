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
public class HockeyFeats implements Feats<HockeyFeats> {
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

    public HockeyFeats build(){
        currentRequest = endpoint;
        return this;
    }

    public HockeyFeats perPage(int num){
        currentRequest = currentRequest + "&" + HockeyParameters.per_page.name() + "=";
        if(num > 40){
            currentRequest += 40;
        }else if(num < 0){
            currentRequest += 1;
        }else{
            currentRequest += num;
        }
        return this;
    }

    public HockeyFeats pageOfResults(int pages){
        parameters.put(HockeyParameters.page,String.valueOf(pages));
        return this;
    }

    public HockeyFeats game_id(String gameId){
        parameters.put(HockeyParameters.game_id,gameId);
        return this;
    }

    public HockeyFeats player_id(String playerId){
        parameters.put(HockeyParameters.player_id,playerId);
        return this;
    }

    public HockeyFeats team_id(String team_id){
        parameters.put(HockeyParameters.team_id,team_id);
        return this;
    }

    public HockeyFeats interval_tyoe(HockeyIntervalTypes intervalType){
        parameters.put(HockeyParameters.interval_type,intervalType.name());
        return this;
    }

    public HockeyFeats season_id(String seasonId){
        parameters.put(HockeyParameters.season_id,seasonId);
        return this;
    }

    public HockeyFeats on(String date){
        parameters.put(HockeyParameters.on,date);
        return this;
    }

    public HockeyFeats since(String date){
        parameters.put(HockeyParameters.since,date);
        return this;
    }

    public HockeyFeats level(int level){
        parameters.put(HockeyParameters.level,String.valueOf(level));
        return this;
    }

    public HockeyFeats name(String name){
        parameters.put(HockeyParameters.name,name);
        return this;
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
