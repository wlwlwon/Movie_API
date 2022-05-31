package com.dodatabase.movie_backend.service;

import java.util.List;
import java.util.Optional;

import com.dodatabase.movie_backend.domain.Movie;
import com.dodatabase.movie_backend.repository.MovieRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie create(Movie movie){

        Movie saveMovie = movieRepository.save(movie);
        return saveMovie;
    }

    /**
     * 전체 도서 목록 조회
     */
    public List<Movie> findBooks() {
        return movieRepository.findAll();
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);

    }

    public Optional<Movie> findCondMovie(Movie movie) {
        return movieRepository.findById(movie);
    }

    public Optional<Movie> findByTitle(String keyword) {
        return movieRepository.findByTitle(keyword);
    }
}
