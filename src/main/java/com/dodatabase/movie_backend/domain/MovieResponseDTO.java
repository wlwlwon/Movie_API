package com.dodatabase.movie_backend.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MovieResponseDto {

    private Item[] items;

    @Data
    public static class Item {
        public String title;
        public String link;
        public String subtitle;
        public Date pubDate;
        public String director;
        public String actor;
        public float userRating;
    }

}
