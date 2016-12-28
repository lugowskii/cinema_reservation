package com.lugowski.dao;

import com.lugowski.entities.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat, Long> {
    List<Seat> findByRowOrderByRowAsc(int row);
}
