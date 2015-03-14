package utils;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vlad.tamas on 3/12/2015.
 */
public class CheckBrokenLinks {
    public static String isLinkBroken(URL url) throws Exception{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try{
            connection.connect();
            String response = connection.getResponseMessage();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return response + " " + responseCode;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}