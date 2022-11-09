import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        Request request = new Request.Builder()
                .url("http://geekbrains.ru")
                .build();
        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();
        // Тело сообщения возвращается методом body объекта Response
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());

        /*
        HttpUrl url1 = new HttpUrl.Builder()
                .scheme("http")
                .host("mytestservice.com") //BASE_HOST
                .addPathSegment("v2") //API_VERSION
                .addPathSegment("companies") //COMPANIES_API
                .addPathSegment("2") //COMPANY_ID
                .addQueryParameter("only_manufactures", "true")
                .addQueryParameter("in_top_100", "true")
                .build();

        System.out.println("====================");
        Request request1 = new Request.Builder()
                .url(url1)
                .build();

        Response response1 = client.newCall(request1).execute();

        System.out.println(response1.code());
        System.out.println(response1.headers());
        System.out.println(response1.isRedirect());
        System.out.println(response1.isSuccessful());
        System.out.println(response1.protocol());
        System.out.println(response1.receivedResponseAtMillis());
        */
        System.out.println("=========WEATHER===========");

        Request weatherRequest = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021?apikey=CB3CB4T8qXFPhnBCIVLnTUgk2kZVQ70A")
                .build();

        Response weatherResponse = client.newCall(weatherRequest).execute();

        System.out.println(weatherResponse.code());
        String body = Objects.requireNonNull(weatherResponse.body()).string();
        System.out.println(body);
    }
}
