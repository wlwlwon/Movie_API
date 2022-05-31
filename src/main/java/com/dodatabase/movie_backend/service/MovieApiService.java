package com.dodatabase.movie_backend.service;

import com.dodatabase.movie_backend.domain.Movie;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieApiService {
    
    private final MovieApiClient movieApiClient;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public Movie findByKeyword(String keyword) {

        return modelMapper.map(movieApiClient.requestMovie2(keyword).getItems()[0], Movie.class);
    }

}
