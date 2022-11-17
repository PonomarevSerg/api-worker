import client.AccuWeatherClient;
import client.PicsumClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.locations.TopCitiesCount;
import okhttp3.OkHttpClient;
import service.AccuWeatherService;
import service.PicsumService;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        AccuWeatherClient accuWeatherClient = new AccuWeatherClient(objectMapper, okHttpClient);
        AccuWeatherService accuWeatherService = new AccuWeatherService(accuWeatherClient);

        accuWeatherService.showWeather(TopCitiesCount.HUNDRED);

        PicsumClient picsumClient = new PicsumClient(okHttpClient);
        PicsumService picsumService = new PicsumService(picsumClient);
        picsumService.downloadImageByUrl("");

    }
}
