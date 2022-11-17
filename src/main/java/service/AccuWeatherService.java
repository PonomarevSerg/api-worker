package service;

import client.AccuWeatherClient;
import model.locations.TopCitiesCount;
import model.locations.TopCitiesRoot;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AccuWeatherService {
    private final AccuWeatherClient accuWeatherClient;

    public AccuWeatherService(AccuWeatherClient accuWeatherClient) {
        this.accuWeatherClient = accuWeatherClient;
    }

    public void showWeather(TopCitiesCount topCitiesCount) throws IOException {
        List<TopCitiesRoot> topCities = accuWeatherClient.getTopCities(topCitiesCount);
        System.out.println(topCities);

        System.out.println("Введите ID города:");
        Scanner scanner = new Scanner(System.in);
        TopCitiesRoot topCitiesRoot = topCities.get(scanner.nextInt());
        scanner.close();

        System.out.println(accuWeatherClient.getCurrentCondition(topCitiesRoot));
        System.out.println(accuWeatherClient.getFiveDayForecast(topCitiesRoot));
    }
}
