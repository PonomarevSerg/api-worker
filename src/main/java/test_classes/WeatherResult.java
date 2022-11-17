package test_classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResult {
    private String date;
    private String temperature;
    private final String city = "MOSCOW";
    private String weather;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "test_classes.WeatherResult{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
