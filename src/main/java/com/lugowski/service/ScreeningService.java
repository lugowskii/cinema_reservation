package com.lugowski.service;

import com.lugowski.dao.ScreeningRepository;
import com.lugowski.entities.Screening;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr Ługowski on 24.10.2016.
 */

@Service
@Transactional
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<Screening> findAll(){
        List<Screening> screenings = new ArrayList<>();
        for (Screening screening: screeningRepository.findAll() ){
            screenings.add(screening);
        }
        return screenings;
    }

    public List<Screening> findByMovieId(Long id){
        return screeningRepository.findByMovieId(id);
    }

    public Screening getScreeningById(Long id){
        return screeningRepository.findOne(id);
    }

    public void save(Screening screening){
        screeningRepository.save(screening);
    }

    public void delete(Long id){
        screeningRepository.delete(id);
    }




}
