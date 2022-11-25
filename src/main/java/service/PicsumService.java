package service;

import client.PicsumClient;
import client.UrlToPathCache;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PicsumService {
    private final PicsumClient picsumClient;
    private final UrlToPathCache urlToPathCache;

    public PicsumService(PicsumClient picsumClient,
                         UrlToPathCache urlToPathCache) {
        this.picsumClient = picsumClient;
        this.urlToPathCache = urlToPathCache;

    }

    public void downloadImageByUrl(String url) throws IOException {
        picsumClient.downloadImageByUrl(new URL(url));
    }

    public void getImageByUrl(String url) {
        String pathByUrl = urlToPathCache.getPathByUrl(url);
        System.out.println("getImageByUrl: " + pathByUrl);
    }

    public void downloadListOfImages(List<String> listOfUrls) throws IOException {
        for (String url : listOfUrls) {
            picsumClient.downloadImageByUrl(new URL(url));
        }
    }
}
