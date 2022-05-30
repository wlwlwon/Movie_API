package com.dodatabase.movie_backend.service;

import java.util.List;

import com.dodatabase.movie_backend.domain.Movie;
import com.dodatabase.movie_backend.repository.MovieRepository;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * 전체 도서 목록 조회
     */
    public List<Movie> findBooks() {
        return movieRepository.findAll();
    }

    public List<Movie> deleteMovie(Movie movie) {
        movieRepository.Delete(movie);
        return movieRepository.findAll();
    }

    public List<Movie> findCondMovie(Movie movie) {
        return movieRepository.findCond(movie);
    }
}
