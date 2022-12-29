package Requests;

import POJOs.ImageObject;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImageRequest {

    private Gson gson = new Gson();
    private ImageObject imageObject = null;
    private String responseBody = "";
    private int responseCode = 0;
    private HttpResponse<String> response = null;
    private HttpClient client = null;

    public ImageObject getDogImage() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dog.ceo/api/breeds/image/random"))
                .GET()
                .build();

        client = HttpClient.newHttpClient();
        response = null;

        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            responseBody = response.body();
            responseCode = response.statusCode();
        } catch (Exception e) {
            System.err.println("There was an error with the image");
        }

        if (responseCode == 200) {
            imageObject = gson.fromJson(responseBody, ImageObject.class);
        }

        return imageObject;
    }

}
