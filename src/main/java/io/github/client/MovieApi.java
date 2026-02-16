package io.github.client;

import com.google.gson.Gson;
import io.github.dto.MovieDTO;
import io.github.model.Movie;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieApi {
    public static void connectApi(String link) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(link))
                        .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var json = response.body();

        Gson gson = new Gson();
        MovieDTO dto = gson.fromJson(json, MovieDTO.class);
        Movie movie = new Movie(dto);


    }

}
