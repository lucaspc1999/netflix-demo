package com.netflix.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieApi {
    private int id;
    private String title;
    private String overview;
    private double popularity;
    private double voteAverage;
    private int voteCount;
    private boolean adult;
    private String backdropPath;
    private List<Integer> genreIds;
    private String originalLanguage;
    private String originalTitle;
    private String posterPath;
    private String releaseDate;
    private boolean video;
    private List<MovieApi> results;

}