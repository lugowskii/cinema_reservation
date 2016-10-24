package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.entities.Screening;
import com.lugowski.service.MovieService;
import com.lugowski.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
@Controller
public class MoviePageController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreeningService screeningService;

    @RequestMapping("/moviePage/id/{id}")
    String moviePage(Model model, @PathVariable Long id){
        Movie movieById = movieService.getMovieById(id);
        model.addAttribute("movieById", movieById);
        List<Screening> screeningsByMovie = screeningService.findByMovieId(id);
        model.addAttribute("screeningsByMovie", screeningsByMovie);
        return "moviePage";
    }


}
