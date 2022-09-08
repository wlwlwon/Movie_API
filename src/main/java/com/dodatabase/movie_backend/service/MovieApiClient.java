package com.dodatabase.movie_backend.service;

import com.dodatabase.movie_backend.domain.MovieResponseDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MovieApiClient {

    private final RestTemplate restTemplate;

    @Value("${app.Client-ID}")
    private final String CLIENT_ID;
    @Value("${app.CLIENT_SECRET}")
    private final String CLIENT_SECRET;

    private final String OpenNaverMovieUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query={query}";

    public MovieResponseDTO requestMovie(String keyword) {
        final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
        headers.set("X-NAVER-Client-ID", CLIENT_ID);
        headers.set("X-NAVER-Client-Secret", CLIENT_SECRET);

        Map<String, String> params = new HashMap<>();
        params.put("query", keyword);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate
                .exchange(OpenNaverMovieUrl_getMovies, HttpMethod.GET, entity, MovieResponseDTO.class, params)
                .getBody();
    }

}