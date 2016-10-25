package com.lugowski.dao;

import com.lugowski.entities.Seat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */
public interface SeatRepository extends CrudRepository<Seat, Long>{
    List<Seat> findByRowOrderByRowAsc(int row);
}
