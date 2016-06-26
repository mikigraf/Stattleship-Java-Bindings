package Feats;

import Configuration.Configuration;
import Feats.FeatsParameters.FeatsParameters;
import IntervalTypes.HockeyIntervalTypes;
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
public class HockeyFeats implements Parameters<HockeyFeats> {
    private final static String endpoint = "hockey/nhl/feats";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public HockeyFeats(){
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public void flush(){
        parameters.clear();
    }

    public HockeyFeats build(){
        currentRequest = endpoint;
        return this;
    }

    public HockeyFeats perPage(int num){
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

    public HockeyFeats pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public HockeyFeats game_id(String gameId){
        parameters.put(FeatsParameters.game_id,gameId);
        return this;
    }

    public HockeyFeats player_id(String playerId){
        parameters.put(FeatsParameters.player_id,playerId);
        return this;
    }

    public HockeyFeats team_id(String team_id){
        parameters.put(FeatsParameters.team_id,team_id);
        return this;
    }

    public HockeyFeats interval_tyoe(HockeyIntervalTypes intervalType){
        parameters.put(FeatsParameters.interval_type,intervalType.name());
        return this;
    }

    public HockeyFeats season_id(String seasonId){
        parameters.put(FeatsParameters.season_id,seasonId);
        return this;
    }

    public HockeyFeats on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public HockeyFeats since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public HockeyFeats level(int level){
        parameters.put(FeatsParameters.level,String.valueOf(level));
        return this;
    }

    public HockeyFeats name(String name){
        parameters.put(FeatsParameters.name,name);
        return this;
    }

    public String getCurrentRequest() {
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(Map.Entry<FeatsParameters,String> entry : parameters.entrySet()){
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
