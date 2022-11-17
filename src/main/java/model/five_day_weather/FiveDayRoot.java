package model.five_day_weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class FiveDayRoot {
    @JsonProperty("Headline")
    public Headline headline;
    @JsonProperty("DailyForecasts")
    public ArrayList<DailyForecast> dailyForecasts;

    @Override
    public String toString() {
        return "Root{" +
                "headline=" + headline +
                ", dailyForecasts=" + dailyForecasts +
                '}';
    }
}
