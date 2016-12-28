package com.lugowski.service;

import com.lugowski.dao.ReservationRepository;
import com.lugowski.entities.Reservation;
import com.lugowski.entities.SeatScreeningKey;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void reserveSeatsForScreening(List<Reservation> seats) {
        reservationRepository.save(seats);
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public Reservation findByKey(SeatScreeningKey key) {
        return reservationRepository.findByKey(key);
    }
}
