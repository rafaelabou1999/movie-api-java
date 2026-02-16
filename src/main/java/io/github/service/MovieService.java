package io.github.service;

import io.github.client.MovieApi;
import io.github.model.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    List<Movie> favorites = new ArrayList<>();
    List<Movie> movies = new ArrayList<>();

    public void chooseMovie(String title) throws IOException, InterruptedException {
        Movie movie = new Movie();
        if(title.equalsIgnoreCase(movie.getTitle())){
            movies.add(movie);
        }
    }

    public void saveFavorite(String title) throws IOException, InterruptedException {
        List<Movie> favorites = new ArrayList<>();
        Movie movie = new Movie();
        if(title.equalsIgnoreCase(movie.getTitle())){
            favorites.add(movie);
        }
    }

    public void showFavorites(){
        favorites.forEach(System.out::println);
    }

    public void filterGenre(String genre) throws IOException, InterruptedException {
        System.out.printf("All movies - Genre %s", genre);
        movies.stream()
                .filter(m -> genre.equalsIgnoreCase(m.getGenre()))
                .forEach(System.out::println);
    }
}
