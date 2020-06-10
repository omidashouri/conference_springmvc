package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.services.IHelloService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@AllArgsConstructor
public class HelloController {

    private final IHelloService iHelloService;

    @GetMapping("/first")
    public String hello(Map<String,Object> model){
        model.put("message","omidashouri");
        return "first";
    }

    @GetMapping
    @RequestMapping("/firsts")
    public ModelAndView hellos(ModelMap modelMap){
        modelMap.addAttribute("message","Omid Ashouri (Model Map)");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("first");
        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/firstz")
    public ModelAndView helloz(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Omid Ashouri (Model And View)");
        modelAndView.setViewName("first");
        return modelAndView;
    }

    @RequestMapping(value = "/firstService",method = RequestMethod.GET)
    public ModelAndView firstFromService(){
        return new ModelAndView("first","message",iHelloService.helloMessage());
    }

    @GetMapping("/second")
    public String hello2(Map<String,Object> model){
        model.put("message","omidashouri");
        return "second";
    }

    @GetMapping("thyme")
    public String thyme(Map<String,Object> model){
        model.put("message","Hello Omid Ashouri");
        return "thyme";
    }

}
