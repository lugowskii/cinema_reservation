package com.lugowski.service;

import com.lugowski.dao.ReservationRepository;
import com.lugowski.entities.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void reserveSeatsForScreening(List<Reservation> seats){
        reservationRepository.save(seats);
    }

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public Reservation findReservationById(Long id){
        return reservationRepository.findOne(id);
    }

}
