package Rankings;

import Configuration.Configuration;
import Feats.FeatsParameters.BaseballFeatsParameters;
import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Ranking {
    private final static String endpoint = "ranking";

    public Ranking(){

    }

    public void getBaseballRanking(BaseballRankings ranking){

    }

    public void getBasketballRanking(BasketballRankings ranking){

    }

    public String getHockeyRanking(HockeyRankings ranking){
        URIBuilder builder = null;
        try {
            builder = new URIBuilder(new Configuration().getApiEndpoint() + endpoint + ranking.name());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //todo: check whats the correct endpoint for the rankings
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
