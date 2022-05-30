package com.dodatabase.movie_backend.repository;

import com.dodatabase.movie_backend.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// jpa 사용 안할 시 변경
public interface MovieRepository extends JpaRepository<Movie,Long> {


}
