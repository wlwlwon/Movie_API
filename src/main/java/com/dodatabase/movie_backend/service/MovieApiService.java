package com.dodatabase.movie_backend.service;

import com.dodatabase.movie_backend.domain.Movie;

import com.dodatabase.movie_backend.domain.MovieResponseDTO;
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
        MovieResponseDTO.Item item = movieApiClient.requestMovie2(keyword).getItems()[0];
        String title_before = item.getTitle();
        title_before = title_before.replace("<b>","").replace("</b>","");
        item.setTitle(title_before);
        return modelMapper.map(item, Movie.class);
    }

}
