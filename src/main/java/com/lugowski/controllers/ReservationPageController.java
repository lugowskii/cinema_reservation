package com.lugowski.controllers;

import com.lugowski.entities.Customer;
import com.lugowski.entities.Seat;
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

import java.util.List;

@Controller
class ReservationPageController {

    private final SeatService seatService;
    private final ReservationService reservationService;
    private final CustomerService customerService;

    @Autowired
    public ReservationPageController(SeatService seatService, ReservationService reservationService, CustomerService customerService) {
        this.seatService = seatService;
        this.reservationService = reservationService;
        this.customerService = customerService;
    }

    @RequestMapping("/reservation/{screeningId}")
    public String reservationPage(Model model, @PathVariable Long screeningId) {
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
                              @ModelAttribute("customer") Customer customer) {
        if (!reservationService.isReservationPossible(screeningId, choosenSeatsData)) {
            return "reservationFailed";
        }
        else {
            Customer added = customerService.saveCustomer(customer);
            reservationService.reserveSeats(screeningId, choosenSeatsData, added.getId());
            return "reservationSuccess";
        }
    }

}
