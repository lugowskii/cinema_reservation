package com.lugowski.dao;

import com.lugowski.entities.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Piotr Ługowski on 21.10.2016.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
