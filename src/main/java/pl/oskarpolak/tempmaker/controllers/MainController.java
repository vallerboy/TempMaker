package pl.oskarpolak.tempmaker.controllers;

import pl.oskarpolak.tempmaker.models.LoadWeatherService;
import pl.oskarpolak.tempmaker.models.dto.WeatherDto;
import pl.oskarpolak.tempmaker.views.MenuView;

public class MainController {
    private MenuView menuView;
    private LoadWeatherService loadWeatherService;

    public MainController(){
        menuView = new MenuView();
        loadWeatherService = new LoadWeatherService();
    }

    public void startApp(){
        do{
            getWeather(
                    menuView.getCity());
        }while (true);
    }

    private void getWeather(String city) {
        WeatherDto weatherDto = loadWeatherService.loadWeatherFor(city);
        menuView.printWeather(weatherDto);
    }
}
