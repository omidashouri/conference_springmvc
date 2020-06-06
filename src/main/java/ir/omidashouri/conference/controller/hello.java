package ir.omidashouri.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller("/conference")
public class hello {

    @GetMapping
    public String hello(Map<String,Object> model){
        model.put("message","omidashouri");
        return "index";
    }

    @GetMapping("/se")
    public String hello2(Map<String,Object> model){
        model.put("message","omidashouri");
        return "index2";
    }
}
