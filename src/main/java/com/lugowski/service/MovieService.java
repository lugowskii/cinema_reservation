package com.lugowski.service;

import com.lugowski.dao.MovieRepository;
import com.lugowski.entities.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll(){
        List<Movie> movies = new ArrayList<>();
        for (Movie movie:movieRepository.findAll()){
            movies.add(movie);
        }
        return movies;
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }

    public void delete(Long id){
        movieRepository.delete(id);
    }

}
