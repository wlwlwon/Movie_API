package com.dodatabase.movie_backend.controller;

import com.dodatabase.movie_backend.domain.Movie;
import com.dodatabase.movie_backend.service.MovieApiService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("api/v1")
public class MovieApiController {

    private final MovieApiService movieApiService;

    @GetMapping("/api/v1/movies/{keyword}")
    public Movie get(@PathVariable String keyword) {
        return movieApiService.findByKeyword(keyword);
    }

}