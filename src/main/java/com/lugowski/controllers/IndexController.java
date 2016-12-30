package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class IndexController {

    private MovieService movieService;

    public IndexController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/")
    String index(Model model) {
        return "index";
    }

    @ModelAttribute(value = "movies")
    List<Movie> list() {
        return movieService.findAll();
    }

}
