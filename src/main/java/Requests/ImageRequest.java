package Requests;

import POJOs.ImageObject;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImageRequest {
    
    public String getDogImage(){
  
        Gson gson = new Gson();
        ImageObject imageObject = null;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dog.ceo/api/breeds/image/random"))
                .GET()
                .build();
        
        HttpClient client = HttpClient.newHttpClient();       
        HttpResponse<String> response = null;
        
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) { 
            System.err.println("There has been an error with the quest");
        }
        
        String responseBody = response.body();
        int responseCode = response.statusCode();
        
        if (responseCode == 200) {
            imageObject = gson.fromJson(responseBody, ImageObject.class);
        }
        
        return imageObject.getMessage();
    }
    
}
