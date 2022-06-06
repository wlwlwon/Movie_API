package com.dodatabase.movie_backend.repository;

import com.dodatabase.movie_backend.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMovieRepository {

    private static Map<Long, Movie> store = new HashMap<>();
    private static long sequence = 0L;

 //   @Override
    public List<Movie> findAll() {
        return new ArrayList<>(store.values());
    }

  //  @Override
    public Movie save(Movie movie) {
        movie.setId(++sequence);
        store.put(movie.getId(), movie);
        return movie;
    }
}
