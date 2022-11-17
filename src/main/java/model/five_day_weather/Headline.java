package model.five_day_weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Headline {
    @JsonProperty("EffectiveDate")
    public Date effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    public int effectiveEpochDate;
    @JsonProperty("Severity")
    public int severity;
    @JsonProperty("Text")
    public String text;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("EndDate")
    public Object endDate;
    @JsonProperty("EndEpochDate")
    public Object endEpochDate;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;

    @Override
    public String toString() {
        return "Headline{" +
                "effectiveDate=" + effectiveDate +
                ", effectiveEpochDate=" + effectiveEpochDate +
                ", severity=" + severity +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", endDate=" + endDate +
                ", endEpochDate=" + endEpochDate +
                ", mobileLink='" + mobileLink + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
