package pl.oskarpolak.tempmaker.models;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadWeatherService {
    public void loadWeatherFor(String cityName){
        System.out.println(readWebsite("https://api.openweathermap.org/data/2.5/weather?q="
                        + cityName
                        + "&appid="
                        + Config.API_KEY));
    }

    private String readWebsite(String url){
        StringBuilder content = new StringBuilder();
        try {
             HttpURLConnection http = (HttpURLConnection) new URL(url).openConnection();
             http.setRequestMethod("GET");

             InputStream inputStream =  http.getInputStream();

             int data = inputStream.read();
             while (data != -1){
                 content.append((char) data);

                 data = inputStream.read();
             }
             inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
