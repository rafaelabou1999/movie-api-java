package io.github.service;

import io.github.client.MovieApi;
import io.github.model.Movie;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> favorites = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getFavorites() {
        return favorites;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void chooseMovie(Movie movie) throws IOException, InterruptedException {
        boolean exists = false;
        for(Movie m: movies){
            if(m.getTitle().equalsIgnoreCase(movie.getTitle())){
                exists = true;
                break;
            }
        }

        if(exists){
            System.out.println("This movie has already been inserted!");
        } else {
            movies.add(movie);
            System.out.println("Successfully added");
        }
    }

    public void saveFavorite(String title) throws IOException, InterruptedException {

        Movie movie = MovieApi.connectApi(title);

        boolean exists = favorites.stream().anyMatch(f -> f.getTitle().equalsIgnoreCase(title));

        if(exists){
            System.out.println("This movie has already been inserted!");
        } else {
            favorites.add(movie);
            System.out.println("Movie saved to favorites");
        }


    }


    public void showFavorites(){
        favorites.forEach(System.out::println);
    }

    public List<String> getGenreFromMovies(){
        return movies.stream()
                .map(Movie::getGenre)
                .collect(Collectors.toList());
    }


    public void filterGenre(String genreInput) throws IOException, InterruptedException {
        List<String> allGenres = getGenreFromMovies();
        movies.stream().filter(m -> m.getGenre().equalsIgnoreCase(genreInput)).forEach(System.out::println);

    }

    public void showAllMovies(){
        System.out.println("---------- MOVIES -----------");
        movies.forEach(System.out::println);
        System.out.println("--------------------------");
    }
}
