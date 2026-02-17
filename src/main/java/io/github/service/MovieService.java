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
    List<Movie> favorites = new ArrayList<>();
    public List<Movie> movies = new ArrayList<>();


    public void chooseMovie(String title) throws IOException, InterruptedException {
        String encondedLink = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String link = "http://www.omdbapi.com/?apikey=7a43f72&t=" + encondedLink;
        Movie movie = MovieApi.connectApi(link);
        movies.add(movie);
    }

    public void saveFavorite(String title) throws IOException, InterruptedException {
        String encondedLinkFav = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String link = "http://www.omdbapi.com/?apikey=7a43f72&t=" + encondedLinkFav;
        Movie movie = MovieApi.connectApi(link);

        List<String> titles = movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());

        if(titles.contains(movie.getTitle())){
            favorites.add(movie);
        } else {
            System.out.println("This movie has not been inserted yet!");
        }
    }

    public void showFavorites(){
        favorites.forEach(System.out::println);
    }

    public void filterGenre(String genre) throws IOException, InterruptedException {
        System.out.printf("All movies - Genre %s%n", genre);

        List<String> genreMovie = movies.stream()
                .map(m -> m.getGenre())
                .collect(Collectors.toList());

        if(genreMovie.contains(genre)){
            movies.forEach(System.out::println);
        }
    }

    public void showAllMovies(){
        movies.forEach(m -> System.out.println("Movie: " + m.getTitle()));
    }
}
