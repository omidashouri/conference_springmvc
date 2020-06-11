package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
