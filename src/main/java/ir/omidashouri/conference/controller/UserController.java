package ir.omidashouri.conference.controller;

import ir.omidashouri.conference.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        modelAndView.addObject("nameTextBox","nameTextBox1");
        modelAndView.setViewName("userFormWithObject");
        return modelAndView;
    }

    @GetMapping(path = "/openUserWo")
    public ModelAndView openUserWo(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("firstName","1212");
        modelAndView.addObject("nameTextBox","omid1");
        modelAndView.addObject("lastName","llllllll");
        modelAndView.addObject("age","38");
        modelAndView.setViewName("userFormWithoutObject");
        return modelAndView;
    }

    @PostMapping(path = "/userinputwoo"
/*            ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
            ,produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE*/
    )
    public ResponseEntity<?> PostForEntitySend(HttpServletRequest httpServletRequest,
                                               @RequestParam(value = "firstName",required = false) String firstNameForm,
                                               @RequestParam(value = "nameTextBox",required = false) String firstNameTextBox){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> request= new LinkedMultiValueMap<String, String>();
        request.add("firstNameForm", firstNameForm);
        request.add("firstNameTextBox", firstNameTextBox);

//        HttpEntity<> entity = new HttpEntity<>(null,map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate
                                            .postForEntity( "http://localhost:8080/conference/postentityreceive",
                                                    request ,
                                                    String.class);
        return responseEntity;
    }

    @PostMapping(path = "/postentityreceive")
    public void PostForEntityReceive(@RequestParam("firstNameForm") String firstNameForm,
                                           @RequestParam("firstNameTextBox") String firstNameTextBox) {


        System.out.println("firstNameTextBox: "+firstNameTextBox);
        System.out.println("firstNameTextBox: "+firstNameTextBox);
    }
}
