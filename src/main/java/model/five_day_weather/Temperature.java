package model.five_day_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty("Minimum")
    public Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum maximum;
}
