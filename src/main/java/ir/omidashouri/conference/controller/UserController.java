package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "firstName", defaultValue = "Omid") String firstName,
                        @RequestParam(value = "lastName", defaultValue = "Ashouri") String lastName,
                        @RequestParam(value = "age", defaultValue = "38") int age) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(User user){
        System.out.println("user first name : "+user.getFirstName());
        return user;
    }

    @GetMapping(path = "/openUser")
    public ModelAndView openUser(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",new User());
        modelAndView.setViewName("userFormWithObject");
        return modelAndView;
    }

    @GetMapping(path = "/openUserWo")
    public ModelAndView openUserWo(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("firstName","");
        modelAndView.addObject("firstName1","omid1");
        modelAndView.addObject("lastName","");
        modelAndView.addObject("age","");
        modelAndView.setViewName("userFormWithoutObject");
        return modelAndView;
    }
}
