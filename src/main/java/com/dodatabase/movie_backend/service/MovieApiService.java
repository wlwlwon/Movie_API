package com.dodatabase.movie_backend.service;

import com.dodatabase.movie_backend.domain.Movie;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApiService {
    
    private final MovieApiClient movieApiClient;

    @Transactional(readOnly = true)
    public Movie findByKeyword(String keyword) {
        return movieApiClient.requestMovie(keyword);
    }

}
