package com.demo.springboot.web;

import com.demo.springboot.model.User;
import com.demo.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method= RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method=RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") User registrationDto,
                                      BindingResult theBindingResult,
                                      Model model) {
        if (theBindingResult.hasErrors()) {
            model.addAttribute("user", registrationDto);
            return "registration";
        } else {
            userService.save(registrationDto);
        }

        return "redirect:/registration?success";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/welcome", method={RequestMethod.POST, RequestMethod.GET})
    public String welcome() {
        return "welcome";
    }
}
