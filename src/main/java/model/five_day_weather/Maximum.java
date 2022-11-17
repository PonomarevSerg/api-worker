package model.five_day_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}
