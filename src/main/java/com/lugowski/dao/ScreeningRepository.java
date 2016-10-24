package com.lugowski.dao;

import com.lugowski.entities.Screening;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by Piotr Ługowski on 24.10.2016.
 */
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findByMovieId(Long movieId);
}
