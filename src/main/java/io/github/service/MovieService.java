package io.github.service;

import io.github.client.MovieApi;
import io.github.model.Movie;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    public List<Movie> favorites = new ArrayList<>();
    public List<Movie> movies = new ArrayList<>();


    public void chooseMovie(Movie movie) throws IOException, InterruptedException {
        movies.add(movie);
    }

    public void saveFavorite(String title) throws IOException, InterruptedException {

        Movie movie = MovieApi.connectApi(title);

        List<String> titles = movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());

        if(favorites.contains(movie)){
            System.out.println("This movie has already been inserted");
        } else {
            favorites.add(movie);
        }

        if(titles.contains(movie.getTitle())){
            favorites.add(movie);
        } else {
            System.out.println("This movie has not been inserted yet!");
        }
    }

    public void showFavorites(){
        favorites.forEach(System.out::println);
    }

    public List<String> getGenre(){

        return movies.stream()
                .map(m -> m.getGenre().toLowerCase().split(",")[0])
                .collect(Collectors.toList());
    }


    public void filterGenre(String genre) throws IOException, InterruptedException {
        genre = genre.toLowerCase();
        var genreMovie = this.getGenre();
        System.out.println("---------- GENRE " + genre.toUpperCase() + " -----------");
        String finalGenre = genre;
        movies.stream().filter(m -> m.getGenre().split(",")[0].trim().equalsIgnoreCase(finalGenre)).forEach(System.out::println);

        System.out.println("--------------------------");
    }

    public void showAllMovies(){
        System.out.println("---------- MOVIES -----------");
        movies.forEach(System.out::println);
        System.out.println("--------------------------");
    }
}
