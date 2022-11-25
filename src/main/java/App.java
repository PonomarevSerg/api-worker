import client.AccuWeatherClient;
import client.PicsumClient;
import client.UrlToPathCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.locations.TopCitiesCount;
import okhttp3.OkHttpClient;
import service.AccuWeatherService;
import service.PicsumService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        AccuWeatherClient accuWeatherClient = new AccuWeatherClient(objectMapper, okHttpClient, args[0]);
        AccuWeatherService accuWeatherService = new AccuWeatherService(accuWeatherClient);

        accuWeatherService.showWeather(TopCitiesCount.HUNDRED);
/*
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            urlList.add("https://picsum.photos/id/" + i + "/5000/3333");
        }

        urlList.add("https://picsum.photos/id/3/5000/3333");
        urlList.add("https://picsum.photos/id/6/5000/3333");
        urlList.add("https://picsum.photos/id/9/5000/3333");

        UrlToPathCache urlToPathCache = new UrlToPathCache();
        PicsumClient picsumClient = new PicsumClient(urlToPathCache);
        PicsumService picsumService = new PicsumService(picsumClient, urlToPathCache);

        picsumService.downloadListOfImages(urlList);

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                picsumService.downloadImageByUrl(sc.nextLine());
                picsumService.getImageByUrl(sc.nextLine());
            }
        }*/
    }
}
