package com.lugowski.service;

import com.lugowski.dao.SeatRepository;
import com.lugowski.entities.Seat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */
@Service
@Transactional
public class SeatService {

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> findAllSeats(){
        List<Seat> allSeats =new ArrayList<>();
        for (Seat seat:seatRepository.findAll()){
            allSeats.add(seat);
        }
        return allSeats;
    }

}
