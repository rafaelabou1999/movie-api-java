package io.github.dto;

import com.google.gson.annotations.SerializedName;

public record MovieDTO(
        @SerializedName("Title") String title,
        @SerializedName("Genre") String genre,
        @SerializedName("Year") String year,
        @SerializedName("Rated") String rated,
        @SerializedName("Awards") String awards,
        @SerializedName("imdbRating") String imdbRating
) {
}
