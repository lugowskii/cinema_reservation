package com.lugowski.controllers;

import com.lugowski.dao.MovieRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
@Controller
public class IndexController {

    @Autowired
    private MovieRepository movieRepository;
    @RequestMapping("/")
    String index(HttpServletRequest request){
        request.setAttribute("showAllMovies", movieRepository.findAll());
        return "index";
    }
}
