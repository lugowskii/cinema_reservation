package com.lugowski.controllers;

import com.lugowski.entities.UserCreateForm;
import com.lugowski.service.UserService;
import com.lugowski.validators.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    final static String USER_CREATE = "user_create";
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        return new ModelAndView("user", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    @GetMapping("user/create")
    public ModelAndView getUserCreatePage() {
        return new ModelAndView(USER_CREATE, "form", new UserCreateForm());
    }

    @PostMapping("user/create")
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return USER_CREATE;
        }
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("email.exists", "Email already exists");
            return USER_CREATE;
        }
        return "redirect:/users";
    }


}
