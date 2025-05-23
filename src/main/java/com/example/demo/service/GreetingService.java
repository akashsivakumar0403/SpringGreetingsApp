package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;
    public Greeting getSimpleGreeting() {
        return new Greeting(0, "Hello World");
    }

    public Greeting getPersonalizedGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, Mr/Ms. " + lastName + "!";
        } else {
            message = "Hello World";
        }

        return new Greeting(100, message);
    }
    public Greeting save(Greeting greeting) {
        return greetingRepository.save(greeting);
    }
    public Greeting findById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));
    }
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    public Greeting updateGreeting(long id, Greeting updatedGreeting) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));

        existingGreeting.setMessage(updatedGreeting.getMessage());

        return greetingRepository.save(existingGreeting);
    }
   }
