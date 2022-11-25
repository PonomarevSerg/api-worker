package client;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PicsumClient {
    private final Map<String, String> hexToPathCache = new HashMap<>();

    private final UrlToPathCache urlToPathCache;

    public PicsumClient(UrlToPathCache urlToPathCache) {
        this.urlToPathCache = urlToPathCache;
    }

    public Map<String, String> getHexToPathCache() {
        return Collections.unmodifiableMap(hexToPathCache);
    }

    public void downloadImageByUrl(URL url) throws IOException {
        System.out.println("Downloading image by url:" + url + "...");
        BufferedImage img = ImageIO.read(url);
        System.out.println("Image download successful!");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", byteArrayOutputStream);

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5ImgHash = md5.digest(byteArrayOutputStream.toByteArray());

            String hexBinaryImgHash = DatatypeConverter.printHexBinary(md5ImgHash);
            System.out.println("Image was hashed with hexBinary: " + hexBinaryImgHash);

            if (hexToPathCache.containsKey(hexBinaryImgHash) ||
                    urlToPathCache.getUrlToPathCache().containsValue(getHexToPathCache().get(hexBinaryImgHash))) {
                String path = getHexToPathCache().get(hexBinaryImgHash);
                System.out.println("Image already exist by path:" + path);
                urlToPathCache.updateCache(url.toString(), path);
            }

            String path = "src/main/resources/image/" + hexBinaryImgHash + ".jpg";
            try (OutputStream outputStream = new FileOutputStream(path)) {
                byteArrayOutputStream.writeTo(outputStream);
                hexToPathCache.put(hexBinaryImgHash, path);
                urlToPathCache.updateCache(url.toString(), path);
                System.out.println("File was saved to: " + path);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}