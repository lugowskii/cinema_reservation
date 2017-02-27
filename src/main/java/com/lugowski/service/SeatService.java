package com.lugowski.service;

import com.lugowski.dao.SeatRepository;
import com.lugowski.entities.Seat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> findAllSeats() {
        List<Seat> allSeats = new ArrayList<>();
        seatRepository.findAll().forEach(allSeats::add);
        return allSeats;
    }

}
