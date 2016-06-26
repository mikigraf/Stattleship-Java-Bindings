package Configuration;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Configuration {
    private static final String API_ENDPOINT = "https://www.stattleship.com/";
    private static final String CONTENT_TYPE = "application/json";
    private static final String ACCEPT = "application/vnd.stattleship.com; version=1";
    private static String API_KEY;

    public Configuration(){

    }

    public Configuration(String apiKey){
        API_KEY = apiKey;
    }

    public static String getApiEndpoint() {
        return API_ENDPOINT;
    }

    public static String getContentType() {
        return CONTENT_TYPE;
    }

    public static String getACCEPT() {
        return ACCEPT;
    }

    public static String getApiKey(){
        return API_KEY;
    }

    public static void setApiKey(String key){
        API_KEY = key;
    }
}
