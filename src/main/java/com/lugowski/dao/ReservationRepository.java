package com.lugowski.dao;

import com.lugowski.entities.Reservation;
import com.lugowski.entities.SeatScreeningKey;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Reservation findByKey(SeatScreeningKey key);
}
