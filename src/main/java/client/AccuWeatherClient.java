package client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.current_conditions.CurrentConditionsRoot;
import model.five_day_weather.FiveDayRoot;
import model.locations.TopCitiesCount;
import model.locations.TopCitiesRoot;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@AllArgsConstructor
public class AccuWeatherClient {
    private final ObjectMapper objectMapper;
    private final OkHttpClient okHttpClient;
    private String apikey; // CB3CB4T8qXFPhnBCIVLnTUgk2kZVQ70A


//    public AccuWeatherClient(ObjectMapper objectMapper,
//                             OkHttpClient okHttpClient) {
//        this.objectMapper = objectMapper;
//        this.okHttpClient = okHttpClient;
//    }

    public List<TopCitiesRoot> getTopCities(TopCitiesCount topCitiesCount) throws IOException {
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/locations/v1/topcities/" + topCitiesCount.getCount() + "?apikey=" + apikey)
                .build();

        System.out.println("Sending rq..." + request);
        Response response = okHttpClient.newCall(request).execute();
        System.out.println("Received rs..." + response);
        String rsString = Objects.requireNonNull(response.body()).string();

        return objectMapper.readValue(rsString, new TypeReference<List<TopCitiesRoot>>() {
        });
    }

    public List<CurrentConditionsRoot> getCurrentCondition (TopCitiesRoot topCitiesRoot) throws IOException {

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/currentconditions/v1/" + topCitiesRoot.key + "?apikey=" + apikey)
                .build();

        System.out.println("Sending rq..." + topCitiesRoot.englishName + "\n" + request);
        Response response = okHttpClient.newCall(request).execute();
        System.out.println("Received rs..." + response);
        String rsCurrentConditionsRoot = Objects.requireNonNull(response.body()).string();

        return objectMapper.readValue(rsCurrentConditionsRoot, new TypeReference<List<CurrentConditionsRoot>>() {
        });
    }

    public FiveDayRoot getFiveDayForecast(TopCitiesRoot topCitiesRoot) throws IOException {
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + topCitiesRoot.key + "?apikey=" + apikey)
                .build();

        System.out.println("Sending rq..." + topCitiesRoot.englishName + "\n" + request);
        Response response = okHttpClient.newCall(request).execute();
        System.out.println("Received rs..." + response);
        String rsStringFiveDayRoot = Objects.requireNonNull(response.body()).string();

        return objectMapper.readValue(rsStringFiveDayRoot, FiveDayRoot.class);
    }
}
