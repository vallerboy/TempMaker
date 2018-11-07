package pl.oskarpolak.tempmaker.models;

import com.google.gson.Gson;
import pl.oskarpolak.tempmaker.models.dto.WeatherDto;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadWeatherService {
    private Gson gson;

    public LoadWeatherService(){
        gson = new Gson();
    }


    public WeatherDto loadWeatherFor(String cityName){
        WeatherDto weatherDto = convertJsonToWeather(readWebsite("https://api.openweathermap.org/data/2.5/weather?q="
                        + cityName
                        + "&appid="
                        + Config.API_KEY));
        return weatherDto;
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

    private WeatherDto convertJsonToWeather(String json){
         return gson.fromJson(json, WeatherDto.class);
    }
}
