package com.lugowski.dao;

import com.lugowski.entities.Reservation;
import com.lugowski.entities.SeatScreeningKey;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    public Reservation findByKey(SeatScreeningKey key);
}
