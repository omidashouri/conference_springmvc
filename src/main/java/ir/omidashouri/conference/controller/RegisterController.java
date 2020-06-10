package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.Registration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegisterController {


    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }

    @GetMapping
    @RequestMapping("/registrations")
    public ModelAndView getRegistrations(){
        ModelAndView modelAndView = new ModelAndView();
        Registration registration = new Registration();
        registration.setName("registrations");
        modelAndView.addObject("registration",registration);
        modelAndView.setViewName("registrations");
        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/registrationz")
    public ModelAndView getRegistrations(ModelMap map){
        Registration registrationz = new Registration();
        registrationz.setName("registrationz");
        map.addAttribute("registration",registrationz);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrations");
        return modelAndView;
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
