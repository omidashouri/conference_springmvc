package ir.omidashouri.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class hello {

    @GetMapping("/first")
    public String hello(Map<String,Object> model){
        model.put("message","omidashouri");
        return "first";
    }

    @GetMapping("/second")
    public String hello2(Map<String,Object> model){
        model.put("message","omidashouri");
        return "second";
    }
}
