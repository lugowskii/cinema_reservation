package com.lugowski.service;

import com.lugowski.dao.MovieRepository;
import com.lugowski.entities.Movie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public Movie findMovieById(Long id){
        return movieRepository.findOne(id);
    }

    public void save(Movie movie){
        movieRepository.save(movie);
    }

}
