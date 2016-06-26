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
