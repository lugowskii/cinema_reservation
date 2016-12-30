package com.lugowski.service;

import com.lugowski.dao.ReservationRepository;
import com.lugowski.entities.Reservation;
import com.lugowski.entities.SeatScreeningKey;
import com.lugowski.wrappers.ChoosenSeatsData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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

    public boolean isReservationPossible(Long screeningId, ChoosenSeatsData choosenSeatsData) {
        List<Long> nonAvailableSeats = new ArrayList<>();
        for (Long seatId : choosenSeatsData.getSeatsReserved()) {
            if (findByKey(new SeatScreeningKey(screeningId, seatId)) != null) {
                nonAvailableSeats.add(seatId);
            }
        }
        return (nonAvailableSeats.size() == 0);
    }

    public void reserveSeats(@PathVariable Long screeningId, ChoosenSeatsData choosenSeatsData, Long customerId) {
        List<Reservation> reservations = new ArrayList<>();
        for (Long seatId : choosenSeatsData.getSeatsReserved()) {
            reservations.add(new Reservation(new SeatScreeningKey(screeningId, seatId), customerId));
        }
        reserveSeatsForScreening(reservations);
    }

}
