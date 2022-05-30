package com.dodatabase.movie_backend.service;

import lombok.RequiredArgsConstructor;

import com.dodatabase.movie_backend.domain.Movie;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class MovieApiClient {
    private final RestTemplate restTemplate;

    private final String CLIENT_ID = "Hqsz1tECcg712EE903wl";
    private final String CLIENT_SECRET = "av_jqTlPjr";

    private final String OpenNaverMovieUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query={keyword}";

    public Movie requestMovie(String keyword) {
        final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverMovieUrl_getMovies, HttpMethod.GET, entity, Movie.class, keyword)
                .getBody();
    }
}