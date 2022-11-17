package client;

import okhttp3.OkHttpClient;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PicsumClient {
    private final OkHttpClient okHttpClient;
    private final Map <String, String> imgCache = new HashMap<>();

    public Map<String, String> getImgCache() {
        return imgCache;
    }

    public PicsumClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }



    public String downloadImageByUrl (String url1) throws IOException {
        URL url = new URL(url1);
        BufferedImage img = ImageIO.read(url);
        File file = new File("C:\\Users\\MSI\\Desktop\\Courses\\api-worker\\src\\main\\resources\\image\\image" + imgCache.size() + ".jpg");
        if (!file.exists()) {
            ImageIO.write(img, "jpg", file);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", byteArrayOutputStream);
        byte[] temp = byteArrayOutputStream.toByteArray();
        imgCache.put(Arrays.toString(temp), file.getAbsolutePath());
        System.out.println("File downloaded successfully!");
        return file.getAbsolutePath();
    }

    public String isSameImage (String filePath) throws IOException {
        File file = new File(filePath);
        BufferedImage img = ImageIO.read(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", byteArrayOutputStream);
        byte[] temp = byteArrayOutputStream.toByteArray();
        if (!imgCache.containsKey(Arrays.toString(temp))) {
            imgCache.put(Arrays.toString(temp), file.getAbsolutePath());
            return imgCache.get(Arrays.toString(temp));
        }
        System.out.println("File already exists. Path:\n");
        boolean b = file.delete();
        return imgCache.get(Arrays.toString(temp));
    }
}
