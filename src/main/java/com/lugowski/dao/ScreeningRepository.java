package com.lugowski.dao;

import com.lugowski.entities.Screening;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findByMovieIdOrderByDateTimeAsc(Long movieId);
}
