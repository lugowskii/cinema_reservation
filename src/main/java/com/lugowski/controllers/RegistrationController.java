package com.lugowski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public ModelAndView getRegisterPage(@RequestParam Optional<String> error) {
        return new ModelAndView("register", "error", error);

    }
}
