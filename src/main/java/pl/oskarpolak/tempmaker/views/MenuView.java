package pl.oskarpolak.tempmaker.views;

import pl.oskarpolak.tempmaker.models.dto.WeatherDto;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public String getCity(){
        printString("Podaj nazwę miasta: ");
        return scanner.nextLine();
    }

    private void printString(String s) {
        System.out.println(s);
    }

    public void printWeather(WeatherDto weatherDto){
        printString(weatherDto.getTempDto().getTemp() + " " + weatherDto.getCloudDto().getCloudy());
    }

    public void printAvg(double avg){
        printString("Srednia temp to: " + avg);
    }
}
