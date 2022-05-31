package com.dodatabase.movie_backend.controller;

import com.dodatabase.movie_backend.domain.Movie;
import com.dodatabase.movie_backend.service.MovieApiService;

import com.dodatabase.movie_backend.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MovieApiController {

    private final MovieApiService movieApiService;
    private final MovieService movieService;

    @PostMapping("/movies/{keyword}")
    public ResponseEntity<Movie> get(@PathVariable String keyword) {

        Movie result = null;
        Optional<Movie> byTitle = movieService.findByTitle(keyword);

        /**
         * db에서 keyword조회후 존재하면 db에 있는 값 반환
         */

        if(byTitle.isEmpty()){
            Movie byKeyword = movieApiService.findByKeyword(keyword);
            result = movieService.create(byKeyword);
        }else{
            result = byTitle.get();
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}