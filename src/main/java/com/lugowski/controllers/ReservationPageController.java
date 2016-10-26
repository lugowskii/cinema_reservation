package com.lugowski.controllers;

import com.lugowski.entities.Customer;
import com.lugowski.entities.Reservation;
import com.lugowski.entities.Seat;
import com.lugowski.entities.SeatScreeningKey;
import com.lugowski.service.CustomerService;
import com.lugowski.service.ReservationService;
import com.lugowski.service.SeatService;
import com.lugowski.wrappers.ChoosenSeatsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr Ługowski on 25.10.2016.
 */

@Controller
public class ReservationPageController {

    @Autowired
    private SeatService seatService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/reservation/{screeningId}")
    public String reservationPage(Model model, @PathVariable Long screeningId){
        List<Seat> allSeats = seatService.findAllSeats();
        model.addAttribute("allSeats", allSeats);
        ChoosenSeatsData choosenSeatsData = new ChoosenSeatsData();
        model.addAttribute("choosenSeatsData", choosenSeatsData);
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "reservation";
    }

    @PostMapping("/reservation/{screeningId}/submit")
    public String submitSeats(@PathVariable Long screeningId,
                              @ModelAttribute("choosenSeatsData") ChoosenSeatsData choosenSeatsData,
                              @ModelAttribute("customer") Customer customer){
        List<Long> nonAvailableSeats = new ArrayList<>();
        for (Long seatId:choosenSeatsData.getSeatsReserved()){
            if (reservationService.findByKey(
                    new SeatScreeningKey(screeningId,seatId)) != null){
                nonAvailableSeats.add(seatId);
            }
        }
        if (nonAvailableSeats.size() != 0) return "reservationFailed";          //if we can add reservation
        else{
            Customer toAdd = new Customer(customer.getName(), customer.getSurname(), customer.getEmail());
            customerService.save(toAdd);
            Customer added = customerService.findIdByCustomer(toAdd);
            ArrayList<Reservation> reservations = new ArrayList<>();
            for (Long seatId: choosenSeatsData.getSeatsReserved()) {
                reservations.add(new Reservation(new SeatScreeningKey(screeningId,seatId), added.getId()));
            }
            reservationService.reserveSeatsForScreening(reservations);
            return "reservationSuccess";
        }

    }

}
