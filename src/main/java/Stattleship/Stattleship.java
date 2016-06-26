package Stattleship;

import Configuration.Configuration;
import Utils.Connector;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Stattleship {
    private static String apiKey;
    private static Configuration configuration;
    private Connector connector;

    public Stattleship(){
        configuration = new Configuration();
    }

    public Stattleship(String apiKey){
        configuration = new Configuration(apiKey);
    }

    public String testConnection(){
        connector = new Connector();
        return connector.get("baseball/mlb/feats");
    }

    public String connect(String url){
        connector = new Connector();
        return connector.get(url);
    }
}
