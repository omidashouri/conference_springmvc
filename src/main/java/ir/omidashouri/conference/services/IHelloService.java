package ir.omidashouri.conference.services;

import org.springframework.stereotype.Service;

@Service
public class IHelloService implements HelloService {
    @Override
    public String helloMessage() {
        return "Hello Omid Ashouri (Service)";
    }
}
