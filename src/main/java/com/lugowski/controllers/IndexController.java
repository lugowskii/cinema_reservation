package com.lugowski.controllers;

import com.lugowski.dao.MovieRepository;
import com.lugowski.entities.Movie;
import com.lugowski.service.MovieService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;
    @RequestMapping("/")
    String index(Model model){
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies",movies);
        //request.setAttribute("showAllMovies", movieService.findAll());
        return "index";
    }
}
