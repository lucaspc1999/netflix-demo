package com.netflix.demo.service;

import com.netflix.demo.model.MovieApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public TmdbService(RestTemplate restTemplate, @Value("${tmdb.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public MovieApi getPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieApi.class);
    }
}
