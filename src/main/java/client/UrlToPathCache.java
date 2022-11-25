package client;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UrlToPathCache {
    private final Map<String, String> urlToPathCache = new HashMap<>();

    public String getPathByUrl(String url) {
        return urlToPathCache.get(url);
    }

    public Map<String, String> getUrlToPathCache() {
        return Collections.unmodifiableMap(urlToPathCache);
    }

    public void updateCache(String url, String path) {
        urlToPathCache.put(url, path);
    }
}
