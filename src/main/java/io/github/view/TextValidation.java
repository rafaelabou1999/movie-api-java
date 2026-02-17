package io.github.view;

import io.github.client.MovieApi;
import io.github.model.Movie;
import io.github.service.MovieService;


import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextValidation {
    public Movie validateInput(Scanner sc, String info) throws IOException, InterruptedException {
        while(true){
            System.out.println(info);
            var data = sc.nextLine();
            Movie movie = MovieApi.connectApi(data);
            if(movie.getTitle().equalsIgnoreCase(data)){
                return movie;
            } else{
                System.out.println("Error. This movie doesn't exist on the API");

            }
            if (movie.getTitle().matches("[a-zA-ZÀ-ÿ ]+")) return movie;



        }

    }
}
