package model.locations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class TopCitiesRoot {
    public static int counter = -1;

    @JsonProperty("Key")
    public String key;
    @JsonProperty("EnglishName")
    public String englishName;

    @Override
    public String toString() {
        counter++;
        return "\n" + "ID:" + counter + " - {" +
                "Ключ='" + key + '\'' +
                ", Город='" + englishName + '\'' +
                '}';
    }
}
