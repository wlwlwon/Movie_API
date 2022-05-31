package com.dodatabase.movie_backend.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String link;

    private Date pubDate;

    private String director;

    private String actor;

    private float userRating;
}
