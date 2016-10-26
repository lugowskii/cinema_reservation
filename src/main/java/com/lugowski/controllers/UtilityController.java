package com.lugowski.controllers;

import com.lugowski.entities.Movie;
import com.lugowski.entities.Screening;
import com.lugowski.entities.Reservation;
import com.lugowski.service.MovieService;
import com.lugowski.service.ScreeningService;
import com.lugowski.service.ReservationService;
import com.lugowski.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */

@RestController
public class UtilityController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreeningService screeningService;

    @RequestMapping("/movies")
    public List<Movie> allMovies(){
        return movieService.findAll();
    }

    @RequestMapping("/save_movie")
    public void saveMovie(@RequestParam String name){
        Movie movie = new Movie(name,"kraj", 2015, "a",
                LocalDate.of(1999,12,11),"Cameron","Lopez","szwedzki", "jak_zostac_kotem.jpg");
        movieService.save(movie);
    }

    @RequestMapping("/screenings")
    public List<Screening> allScreenings(){
        return screeningService.findAll();
    }

    @RequestMapping("/screenings_id")
    public List<Screening> screeningsByMovieId(){
        return screeningService.findByMovieId(new Long(1));
    }

}
