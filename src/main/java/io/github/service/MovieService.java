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
        movies.add(movie);
    }

    public void saveFavorite(String title) throws IOException, InterruptedException {

        Movie movie = MovieApi.connectApi(title);

        List<String> titles = movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());

        if(favorites.contains(movie)){
            System.out.println("This movie has already been inserted");
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
