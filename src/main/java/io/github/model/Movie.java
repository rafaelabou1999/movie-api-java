package io.github.model;

import com.google.gson.annotations.SerializedName;
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
        this.year = Integer.parseInt(dto.year().substring(0,4));
        try {
            this.rated = Double.parseDouble(dto.rated());
        } catch (Exception e) {
            this.rated = 0.0;
        }
        this.awards = dto.awards();
        try {
            this.imdbRating = Double.parseDouble(dto.imdbRating());
        } catch (Exception e) {
            this.imdbRating = 0.0;
        }
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

    @Override
    public String toString() {
        return this.getTitle() + " / " + this.getYear() ;
    }
}
