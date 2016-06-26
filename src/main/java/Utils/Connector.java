package Utils;

import Configuration.Configuration;
import Stattleship.YOUR_ACCESS_TOKEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Mikolaj Wawrzyniak
 */
public class Connector {
    private Configuration configuration;
    public Connector(){
        configuration = new Configuration();
    }

    public String get(String params){
        URL url;
        try{
            url = new URL(params);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type",configuration.getContentType());
            con.setRequestProperty("Authorization",new YOUR_ACCESS_TOKEN().key);
            con.setRequestProperty("Accept",configuration.getACCEPT());

            if(con.getResponseCode() != 200){
                if(con.getResponseCode() == 400){
                    System.out.println("400, Bad Request - Your request has some invalid or missing parameters");
                }else if(con.getResponseCode() == 401){
                    System.out.println("401, Unauthorized - Your api key is wrong");
                }else if(con.getResponseCode() == 404){
                    System.out.println("404, not found - the specified player, team, game or stat could not be found");
                }else if(con.getResponseCode() == 429){
                    System.out.println("429, too many requests, you're requesting too many stats! slow down!");
                }else if(con.getResponseCode() == 500){
                    System.out.println("500, internal server error - we had a problem with our server. try again later!");
                }else if(con.getResponseCode() == 503){
                    System.out.println("503, service unavailable, we're temporally offline for maintenance. please try again later.");
                }

                throw new RuntimeException("Failed to connect! Http response code: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream()
            ));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();
            return output;
        }catch(MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
