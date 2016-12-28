package com.lugowski.service;

import com.lugowski.dao.ScreeningRepository;
import com.lugowski.entities.Screening;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> findAll() {
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

    public List<Screening> findByMovieId(Long id) {
        return screeningRepository.findByMovieIdOrderByDateTimeAsc(id);
    }

}
