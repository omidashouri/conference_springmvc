package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.Registration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegisterController {


    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }


    @PostMapping("/registration")
    public String addRegistration(@Valid @ModelAttribute("registration")Registration registration,
                                  BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println("There were errors");
            return "registration";
        }

        System.out.println("registration name: " + registration.getName());
        return "redirect:registration";
    }
}
