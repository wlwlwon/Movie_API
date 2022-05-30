package com.dodatabase.movie_backend.repository;

import java.util.List;

import com.dodatabase.movie_backend.domain.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// jpa 사용 안할 시 변경
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();

    List<Movie> findCond(Movie movie);

    List<Movie> Save(Movie movie);

    List<Movie> Delete(Movie movie);
}
