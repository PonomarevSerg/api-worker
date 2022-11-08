import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class WeatherResponse {
    public static void main(String[] args) throws IOException {
        //294021 - Moscow, key.
        //CB3CB4T8qXFPhnBCIVLnTUgk2kZVQ70A - Api key.

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        Request weatherRequest = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=CB3CB4T8qXFPhnBCIVLnTUgk2kZVQ70A")
                .build();

        Response weatherResponse = client.newCall(weatherRequest).execute();

        System.out.println(weatherResponse.code());
        String body = Objects.requireNonNull(weatherResponse.body()).string();
        System.out.println(body);

        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResult weatherResult = objectMapper.readValue(body, WeatherResult.class);
        System.out.println(weatherResult);
    }
}
