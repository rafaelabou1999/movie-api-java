package io.github.client;

import com.google.gson.Gson;
import io.github.dto.MovieDTO;
import io.github.model.Movie;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class MovieApi {
    public static Movie connectApi(String data) throws IOException, InterruptedException {
        String encondedLink = URLEncoder.encode(data, StandardCharsets.UTF_8);
        String link = "http://www.omdbapi.com/?apikey=7a43f72&t=" + encondedLink;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(link))
                        .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var json = response.body();

        Gson gson = new Gson();
        MovieDTO dto = gson.fromJson(json, MovieDTO.class);
        if(dto == null || "False".equalsIgnoreCase(dto.Response())){
            System.out.println("Movie not found");
            return null;
        }

        return new Movie(dto);

    }

}
