package com.dodatabase.movie_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dodatabase.movie_backend.domain.MovieForm;
import com.dodatabase.movie_backend.domain.MovieResponseDto;
import com.dodatabase.movie_backend.service.MovieApiService;
import com.dodatabase.movie_backend.service.MovieService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieApiService movieApiService;
    private final MovieService movieService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/api/search")
    public String searchApiForm() {
        return "api/apiSearchForm";
    }

    @PostMapping("/api/search")
    public String searchApi(@RequestParam("keyword") String keyword, Model model) {

        MovieResponseDto.Item[] items = movieApiService.findByKeyword(keyword).getItems();
        model.addAttribute("movies", items);

        for (MovieResponseDto.Item item : items) {
            System.out.println("---------------");
            System.out.println("제목 : " + item.getTitle());
            System.out.println("링크 : " + item.getLink());
            System.out.println("부제 : " + item.getSubtitle());
            System.out.println("개봉 : " + item.getPubDate());
            System.out.println("감독 : " + item.getDirector());
            System.out.println("배우 : " + item.getActor());
            System.out.println("평점 : " + item.getUserRating());
        }

        return "api/apiList";
    }

    @PostMapping("/api/new")
    public void create(MovieForm form) {
        // movieService.create(form);
        System.out.println(form.getTitle());
        System.out.println(form.getLink());
        System.out.println(form.getSubTitle());
        System.out.println(form.getPubDate());
    }
}
