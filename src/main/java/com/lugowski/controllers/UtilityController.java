package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.entities.Screening;
import com.lugowski.service.MovieService;
import com.lugowski.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
class UtilityController {

    private final MovieService movieService;
    private final ScreeningService screeningService;

    @Autowired
    public UtilityController(MovieService movieService, ScreeningService screeningService) {
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @RequestMapping("/movies")
    public List<Movie> allMovies() {
        return movieService.findAll();
    }

    @RequestMapping("/save_movie")
    public void saveMovie(@RequestParam String name) {
        Movie movie = new Movie(name, "kraj", 2015, "a",
                LocalDate.of(1999, 12, 11), "Cameron", "Lopez", "szwedzki", "jak_zostac_kotem.jpg");
        movieService.save(movie);
    }

    @RequestMapping("/screenings")
    public List<Screening> allScreenings() {
        return screeningService.findAll();
    }

    @RequestMapping("/screenings_id")
    public List<Screening> screeningsByMovieId() {
        return screeningService.findByMovieId(1L);
    }

}
