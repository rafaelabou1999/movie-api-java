package io.github.model;

import io.github.dto.MovieDTO;

public class Movie {
    private String title;
    private int year;
    private double rated;
    private String awards;
    private double imdbRating;
    private String genre;

    public Movie(MovieDTO dto) {
        this.title = dto.title();
        this.year = dto.year();
        this.rated = dto.rated();
        this.awards = dto.awards();
        this.imdbRating = dto.imdbRating();
        this.genre = dto.genre();
    }

    public Movie(){

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRated() {
        return rated;
    }

    public String getAwards() {
        return awards;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public String getGenre() {
        return genre;
    }
}
