package com.netflix.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class MovieApiResponse {
    private int page;
    private List<MovieApi> results;
    private int totalPages;
    private int totalResults;

}
