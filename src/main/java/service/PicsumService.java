package service;

import client.PicsumClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PicsumService {
    private final PicsumClient picsumClient;

    public PicsumService(PicsumClient picsumClient) {
        this.picsumClient = picsumClient;
    }

    public void downloadImageByUrl (String url) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (picsumClient.getImgCache().size() != 10) {
            String pathToImage = picsumClient.downloadImageByUrl(sc.nextLine());
            System.out.println(pathToImage);
            String result = picsumClient.isSameImage(pathToImage);
            System.out.println(result);
        }
        sc.close();
    }
}
