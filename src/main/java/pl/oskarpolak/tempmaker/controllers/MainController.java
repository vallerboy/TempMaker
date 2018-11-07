package pl.oskarpolak.tempmaker.controllers;

import pl.oskarpolak.tempmaker.views.MenuView;

public class MainController {
    private MenuView menuView;

    public MainController(){
        menuView = new MenuView();
    }

    public void startApp(){
        do{
            getWeather(
                    menuView.getCity());
        }while (true);
    }

    private void getWeather(String city) {

    }
}
