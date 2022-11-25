package service;

import client.AccuWeatherClient;
import lombok.RequiredArgsConstructor;
import model.locations.TopCitiesCount;
import model.locations.TopCitiesRoot;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class AccuWeatherService {
    private final AccuWeatherClient accuWeatherClient;

    public void showWeather(TopCitiesCount topCitiesCount) throws IOException {
        List<TopCitiesRoot> topCities = accuWeatherClient.getTopCities(topCitiesCount);
        System.out.println(topCities);

        System.out.println("Введите ID города в диапазоне " + topCitiesCount.getRange() + ": ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.nextInt() < 0 || scanner.nextInt() > topCitiesCount.getCount()) {
                throw new IOException("You are out of range " + topCitiesCount.getRange() + "!");
            }
            TopCitiesRoot topCitiesRoot = topCities.get(scanner.nextInt());
            System.out.println(accuWeatherClient.getCurrentCondition(topCitiesRoot));
            System.out.println(accuWeatherClient.getFiveDayForecast(topCitiesRoot));
        } catch (IOException e) {
            System.out.println("You are out of range " + topCitiesCount.getRange() + "!");
        }
    }
}
