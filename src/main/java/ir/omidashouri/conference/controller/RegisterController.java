package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegisterController {


    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }


    @PostMapping("/registration")
    public String addRegistration(@ModelAttribute("registration")Registration registration){
        System.out.println("registration name: " + registration.getName());
        return "registration";
    }
}
