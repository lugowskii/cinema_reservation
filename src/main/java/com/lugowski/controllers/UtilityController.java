package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */

@RestController
public class UtilityController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> allMovies(){
        return
                movieService.findAll();
    }

    @GetMapping("/save_movie")
    public void saveMovie(@RequestParam String name){
        Movie movie = new Movie(name,"kraj", 2015, "a",
                new Date(20160612),"Cameron","Lopez","szwedzki");
        movieService.save(movie);
    }

    @GetMapping("/delete_movie")
    public void deleteMovie(@RequestParam Long id){
        movieService.delete(id);
    }
}
