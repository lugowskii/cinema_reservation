package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.entities.Screening;
import com.lugowski.service.MovieService;
import com.lugowski.service.ScreeningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MoviePageController {

    private MovieService movieService;
    private ScreeningService screeningService;

    public MoviePageController(MovieService movieService, ScreeningService screeningService) {
        this.movieService = movieService;
        this.screeningService = screeningService;
    }

    @RequestMapping("/movie/{id}")
    String get(@PathVariable Long id, Model model) {
        Movie movieById = movieService.findMovieById(id);
        model.addAttribute("movieById", movieById);
        List<Screening> screeningsByMovie = screeningService.findByMovieId(id);
        model.addAttribute("screeningsByMovie", screeningsByMovie);
        return "movie";
    }

}
