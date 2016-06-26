package Rankings;

import Feats.FeatsParameters.FeatsParameters;
import GameLogs.SportLeague;
import Utils.Builder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Ranking implements Rankings<Ranking> {
    private static String endpoint = "/";
    private Map<FeatsParameters, String> parameters;
    private String currentRequest;

    public Ranking(SportLeague league){
        endpoint =  "rankings";
        currentRequest = endpoint;
        parameters = new HashMap<FeatsParameters, String>();
    }

    public Ranking(Map<FeatsParameters,String> parameters){
        currentRequest = endpoint;
        this.parameters = parameters;
    }

    public void flush(){
        parameters.clear();
    }

    public Ranking build(){
        currentRequest = endpoint;
        return this;
    }

    public Ranking perPage(int num){
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

    public Ranking pageOfResults(int pages){
        parameters.put(FeatsParameters.page,String.valueOf(pages));
        return this;
    }

    public Ranking ranking(String ranking) {
        return null;
    }

    public Ranking on(String date){
        parameters.put(FeatsParameters.on,date);
        return this;
    }

    public Ranking since(String date){
        parameters.put(FeatsParameters.since,date);
        return this;
    }

    public String getCurrentRequest() {
        Builder builder = new Builder(endpoint);
        return builder.getUrlAsString(parameters);
    }
}
